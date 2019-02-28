import java.io.BufferedReader;
import java.io.FileReader;
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
}
