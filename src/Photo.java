import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeSet;

public class Photo {

    int id;
    boolean isHorizontal;
    Integer[] tags;

    public Photo(int id, String info, Hashtable<String, Integer> categories) {
        this.id = id;
        String[] splitted_infos = info.split(" ");

        if (splitted_infos[0].compareTo("H") == 0){
            isHorizontal = true;
        } else {
            isHorizontal = false;
        }

        TreeSet<Integer> local_tags = new TreeSet<>();

        Integer tag;
        for (int i = 2; i < splitted_infos.length; i++) {
            tag = categories.get(splitted_infos[i]);
            if (tag != null){
                local_tags.add(tag);
                continue;
            }
            // If it's a new class, add it to the hashtable
            tag = categories.size();
            categories.put(splitted_infos[i], tag);
            local_tags.add(tag);

        }
        tags = local_tags.toArray(new Integer[0]);
    }
}
