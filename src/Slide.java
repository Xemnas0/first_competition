import java.util.ArrayList;
import java.util.TreeSet;

public class Slide {
    Integer[] tags;
    Photo[] photos;

    public Slide(Photo[] p1, Photo[] p2) {
        ArrayList<Photo> photo_res = new ArrayList<>();
        TreeSet<Integer> tags_res = new TreeSet<>();
        for (Photo p : p1) {
            photo_res.add(p);
            tags_res.addAll(p.tags);
        }
        for (Photo p : p2) {
            photo_res.add(p);
            tags_res.addAll(p.tags);
        }
        photos = photo_res.toArray(new Photo[0]);
        tags = tags_res.toArray(new Integer[0]);
    }
}
