import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] input_filename = {
            "./a_example.txt",
            "./b_lovely_landscapes.txt",
            "./c_memorable_moments.txt",
            "./d_pet_pictures.txt",
            "./e_shiny_selfies.txt"
        };
        Solver solver = new Solver(input_filename[4]);
//        System.out.println(solver.countH());
//        System.out.println(solver.countV());
//        System.out.println(solver.countTags());
//        Slide[] s = solver.merge_verticals();
        Photo[] pl = solver.grouped_photos_by_tag.getOrDefault(solver.grouped_photos_by_tag.keySet().toArray()[0], new ArrayList<>()).toArray(new Photo[0]);
        HashMap<Integer, HashMap<Integer, Integer>> score = Score.score_all_with_all(pl);

        System.out.println();
    }
}
