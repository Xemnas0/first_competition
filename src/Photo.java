public class Photo {

    boolean isHorizontal;

    public Photo(String info) {
        String[] splitted_infos = info.split(" ");
        if (splitted_infos[0].compareTo("H") == 0){
            isHorizontal = true;
        } else {
            isHorizontal = false;
        }

//        for (int i = 2; i < ; i++) {
//
//        }
        System.err.println();
    }
}
