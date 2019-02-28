import java.util.Arrays;

public class Score {
    public int score(Slide s1, Slide s2) {
        Integer[] tags_p1 = s1.tags;
        Integer[] tags_p2 = s2.tags;
//        int common_tags = 0;
//        int tags_in_p1_not_in_p2 = 0;
//        int tags_in_p2_not_in_p1 = 0;
        Integer[] scores = new Integer[3];
        for (int i = 0; i < tags_p1.length; i++) {
            for (int j = 0; j < tags_p2.length; j++) {
                if (tags_p1[i] < tags_p2[j]) {
                    i++;
                    //tags_in_p1_not_in_p2++;
                    scores[1]++;
                } else if (tags_p1[i] > tags_p2[i]) {
                    j++;
                    //tags_in_p2_not_in_p1++;
                    scores[2]++;
                } else {
                    // They are equal
                    //common_tags++;
                    scores[0]++;
                    i++;
                    j++;
                }
            }
        }
        Arrays.sort(scores);
        return scores[0];
    }
}
