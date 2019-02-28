import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Slide {
    Integer[] tags;
    Photo[] photos;

    public Slide(Photo p1, Photo p2) {
        ArrayList<Photo> photo_res = new ArrayList<>();
        TreeSet<Integer> tags_res = new TreeSet<>();
        photo_res.add(p1);
        tags_res.addAll(Arrays.asList(p1.tags));
        if (p2 != null) {
            if (p1.isHorizontal || p2.isHorizontal) {
                throw new IllegalArgumentException("Both photos have to be vertical!");
            }
            photo_res.add(p2);
            tags_res.addAll(Arrays.asList(p2.tags));
        }
        photos = photo_res.toArray(new Photo[0]);
        tags = tags_res.toArray(new Integer[0]);
    }
}
