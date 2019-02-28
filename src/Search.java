import java.util.ArrayList;
import java.util.HashMap;

public class Search {

    int MAX_DEEP = 1;


    Slide[] slideshow = new Slide[];

    int next_slide(HashMap<Integer, HashMap<Integer, Integer>> transitions,
                                                     int current_picture, Photo[] list_photo, int pos_slideshow){
            HashMap<Integer, Integer> next_pictures = transitions.get(current_picture);
            HashMap<Double, ArrayList<Photo>> path = new HashMap<>();
            int max_score = 0;
            int max_pic = 0;
            Photo current_photo = list_photo[current_picture];
            for(Integer picture: next_pictures.keySet()){
                Photo next_photo = list_photo[picture];
                if (current_photo.isHorizontal){
                    System.err.println("no need for new picture in this slide");
                    continue;
                }else {
                    int score = transitions.get(current_picture).get(picture);
                    if (score > max_score && !next_photo.isHorizontal){
                        max_score = score;
                        max_pic = picture;
                    }
                }
            }
            return max_pic;
    }

//    HashMap<Double, ArrayList<Integer>> path_score(int picture, HashMap<Double, ArrayList<Integer>> PathFinal){
//        HashMap<Integer, Double> next_pictures = transitions.get(picture);
//        if (deep == MAX_DEEP){
//            double max_score = 0.0;
//            int max_pic = 0;
//            for (int pic: next_pictures.keySet()){
//                if (next_pictures.get(pic) > max_score){
//                    max_score = next_pictures.get(pic);
//                    max_pic = pic;
//                }
//            }
//            ArrayList<Integer> path = new ArrayList<>();
//            path.add(max_pic);
//            PathFinal.put(max_score, path);
//            return PathFinal;
//
//        }else{
//            int pivot = 0;
//            deep = deep + 1;
//            double[] scores = new double[next_pictures.size()];
//            for(int pic: next_pictures.keySet()){
//                PathFinal = path_score(pic, deep, PathFinal);
//                PathFinal.
//            }
//
//            return PathFinal;
//        }
//    }

}
