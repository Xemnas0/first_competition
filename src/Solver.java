import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Solver {

    int n_photos;
    Photo[] photos;
    Hashtable<String, Integer> categories = new Hashtable<>();

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            n_photos = Integer.valueOf(line);
            photos = new Photo[n_photos];

            for (int i = 0; i < n_photos; i++) {
                line = br.readLine();
                photos[i] = new Photo(line, categories);
                ++i;
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
    }

    public Photo[][] merge_verticals() {
        ArrayList<Photo []> res = new ArrayList<>();
        for (Photo p1 : photos){
            for (Photo p2 : photos) {
                if (!p1.isHorizontal && !p2.isHorizontal) {
                    Photo[] u = {p1, p2};
                    res.add(u);
                }
            }
        }
        return res.toArray(new Photo[0][0]);
    }
}
