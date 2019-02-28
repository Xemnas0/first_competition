import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.LinkedList;

public class Solver {

    int n_photos;
    Photo[] photos;
    LinkedList<String> categories = new LinkedList<>();
    Hashtable<String, Boolean> inserted_categories = new Hashtable<>();

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            n_photos = Integer.valueOf(line);
            photos = new Photo[n_photos];

            int index_photo = 0;
            while (line != null) {
                line = br.readLine();
                photos[index_photo] = new Photo(line, categories, inserted_categories);

                    ++index_photo;
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
    }
}
