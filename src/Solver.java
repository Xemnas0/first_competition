import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    int n_photos;
    Photo[] photos;
    Hashtable<String, Integer> categories = new Hashtable<>();
    Hashtable<Integer, List<Photo>> grouped_photos_by_tag = new Hashtable<>();
    Slide[] slideshow;

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            n_photos = Integer.valueOf(line);
            photos = new Photo[n_photos];

            for (int i = 0; i < n_photos; ++i) {
                line = br.readLine();
                photos[i] = new Photo(i, line, categories);
                List<Photo> photo_by_tag = grouped_photos_by_tag.get(photos[i].tags.length);
                if (photo_by_tag == null) {
                    photo_by_tag = new LinkedList<>();
                    grouped_photos_by_tag.put(photos[i].tags.length, photo_by_tag);
                }
                photo_by_tag.add(photos[i]);
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
        int size_slideshow =  (int) ( countV() / 2 + countH());
        int counter_of_verticals = 0;
        slideshow = new Slide[size_slideshow];

        long count_v = countV();

        int current_n_tags = (Integer)(grouped_photos_by_tag.keySet().toArray()[0]);
        Photo[] pl = grouped_photos_by_tag.getOrDefault(current_n_tags, new ArrayList<>()).toArray(new Photo[0]);
        HashMap<Integer, HashMap<Integer, Integer>> score = Score.score_all_with_all(pl);

        // Pick the highest score
        int highest_score = 0, hs, current_picture = 0, next_picture = 1;
        boolean just_horizontals = false;
        boolean[] picked = new boolean[photos.length];
        HashMap<Integer, Integer> temp_hashmap;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> row : score.entrySet()) {
            temp_hashmap = row.getValue();
            for (Integer k : temp_hashmap.keySet()) {
                if ((hs = temp_hashmap.get(k)) > highest_score) {
                    if (counter_of_verticals >= count_v / 2) {
                        just_horizontals = true;
                    }
                    highest_score = hs;
                    if (!photos[k].isHorizontal && just_horizontals) {
                        continue;
                    }
                    if (picked[k]) {
                        continue;
                    }
                    current_picture = row.getKey();
                    next_picture = k;
                    if (!photos[current_picture].isHorizontal) {
                         counter_of_verticals++;
                    }
                    picked[current_picture] = true;
                    if (!photos[next_picture].isHorizontal) {
                        counter_of_verticals++;
                    }
                    picked[next_picture] = true;
                }
            }
        }
        Photo vert = null;
        if (!photos[current_picture].isHorizontal) {
            HashMap<Integer, Photo> p = grouped_photos_by_tag.get(current_n_tags);
            grouped_photos_by_tag.get(current_n_tags).remove(p);
            vert = photos[Search.next_slide(score, current_picture,
                    p)];
        }
        slideshow[0] = new Slide(photos[current_picture], vert);
        vert = null;
        if (!photos[next_picture].isHorizontal) {
            HashMap<Integer, Photo> p = grouped_photos_by_tag.get(current_n_tags);
            grouped_photos_by_tag.get(current_n_tags).remove(next_picture);
            vert = photos[Search.next_slide(score, next_picture,
                    p)];
        }
        slideshow[1] = new Slide(photos[next_picture], vert);
        int count_elements_non_picked;

        for (int i = 2; i < slideshow.length; i++) {
            count_elements_non_picked = 0;
            for (int j = 0; j < picked.length; j++) {
                if (!picked[j]) count_elements_non_picked++;
            }
            if (count_elements_non_picked <= 100) {
                pl = grouped_photos_by_tag.getOrDefault(current_n_tags++, new ArrayList<>()).toArray(new Photo[0]);
                score = Score.score_all_with_all(pl);
            }
            current_picture = next_picture;
            temp_hashmap = score.get(current_picture);
            for (Integer k : temp_hashmap.keySet()) {
                if ((hs = temp_hashmap.get(k)) > highest_score) {
                    if (counter_of_verticals >= count_v / 2) {
                        just_horizontals = true;
                    }
                    highest_score = hs;
                    if (!photos[k].isHorizontal && just_horizontals) {
                        continue;
                    }
                    if (picked[k]) {
                        continue;
                    }
                    next_picture = k;
                    if (!photos[current_picture].isHorizontal) {
                        counter_of_verticals++;
                    }
                    picked[current_picture] = true;
                    if (!photos[next_picture].isHorizontal) {
                        counter_of_verticals++;
                    }
                    picked[next_picture] = true;
                }
            }
            vert = null;
            if (!photos[next_picture].isHorizontal) {
                HashMap<Integer, Photo> p = grouped_photos_by_tag.get(current_n_tags);
                grouped_photos_by_tag.get(current_n_tags).remove(next_picture);
                vert = photos[Search.next_slide(score, next_picture,
                        p)];
            }
            slideshow[i] = new Slide(photos[next_picture], vert);
        }
    }

    public long countV(){
        return Arrays.stream(photos).map(x -> x.isHorizontal).filter(x -> !x).count();
    }
    public long countH(){
        return Arrays.stream(photos).map(x -> x.isHorizontal).filter(x -> x).count();
    }
    public int countTags(){
        return categories.size();
    }

}
