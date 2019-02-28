import java.util.Hashtable;
import java.util.LinkedList;

public class Photo {

    boolean isHorizontal;
    int[] tags;

    public Photo(String info, LinkedList<String> categories, Hashtable<String, Boolean> inserted_categories) {
        String[] splitted_infos = info.split(" ");

        if (splitted_infos[0].compareTo("H") == 0){
            isHorizontal = true;
        } else {
            isHorizontal = false;
        }

        int n_tags = Integer.valueOf(splitted_infos[1]);
        tags = new int[n_tags];

        Integer tag;
        for (int i = 2; i < splitted_infos.length; i++) {
//            inserted_categories.get(splitted_infos[i]);
//            if (){

                continue;
//            }

        }
    }
}
