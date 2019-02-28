import java.util.ArrayList;

public class Slide {
    int score;
    int[] tags;
    ArrayList<Integer> id1 = new ArrayList<>();
    ArrayList<Integer> id2 = new ArrayList<>();

    public Slide(Photo[] p1, Photo[] p2) {
        for (Photo p : p1) {
            id1.add(p.id);
        }
        for (Photo p : p2) {
            id2.add(p.id);
        }
    }
}
