import java.io.BufferedReader;
import java.io.FileReader;

public class Solver {

    int n_photos;
    Photo[] photos;

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            n_photos = Integer.valueOf(line);
            photos = new Photo[n_photos];

            int index_photo = 0;
            while (line != null) {
                line = br.readLine();
                photos[index_photo] = new Photo(line);
                
                    ++index_photo;
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
    }
}
