import java.util.Arrays;
import java.util.HashMap;

public class Score {
    static public int score(Slide s1, Slide s2) {
        Integer[] tags_p1 = s1.tags;
        Integer[] tags_p2 = s2.tags;
//        int common_tags = 0;
//        int tags_in_p1_not_in_p2 = 0;
//        int tags_in_p2_not_in_p1 = 0;
        int[] scores = new int[3];
        for (int i = 0; i < tags_p1.length; i++) {
            for (int j = 0; j < tags_p2.length; j++) {
                if (tags_p1[i] < tags_p2[j]) {
                    if (i + 1 < tags_p1.length) {
                        i++;
                        //tags_in_p1_not_in_p2++;
                        scores[1]++;
                    }
                } else if (tags_p1[i] > tags_p2[j]) {
                    if (j + 1 < tags_p2.length) {
                        j++;
                        //tags_in_p2_not_in_p1++;
                        scores[2]++;
                    }
                } else {
                    // They are equal
                    //common_tags++;
                    scores[0]++;
                    if ( i + 1 < tags_p1.length)
                        i++;
                    if ( j + 1 < tags_p2.length)
                        j++;
                }
            }
        }
        Arrays.sort(scores);
        return scores[0];
    }

    static public HashMap<Integer, HashMap<Integer, Integer>> score_non_decreasing(Photo[] input_photos) {
        HashMap<Integer, HashMap<Integer, Integer>> res = new HashMap<>();
        Integer scr;
        for (Photo p1: input_photos) {
//            System.out.printf("%d\n", p1.id);
            for (Photo p2: input_photos) {
                if (res.get(p2.id) != null && (scr = res.get(p2.id).get(p1.id)) != null) {
                    res.putIfAbsent(p1.id, new HashMap<>());
                    res.get(p1.id).put(p2.id, scr);
                }
                Slide s1 = new Slide(p1, null);
                Slide s2 = new Slide(p2, null);
                scr = score(s1, s2);
                if (scr > 0) {
                    res.putIfAbsent(p1.id, new HashMap<>());
                    res.get(p1.id).put(p2.id, scr);
                }
            }
        }
        return res;
    }
}
