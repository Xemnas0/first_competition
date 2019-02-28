import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solver {

    int n_photos;
    Photo[] photos;
    Hashtable<String, Integer> categories = new Hashtable<>();
    Hashtable<Integer, List<Photo>> grouped_photos_by_tag = new Hashtable<>();

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
