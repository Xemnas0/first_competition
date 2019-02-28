import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solver {

    int n_photos;
    Photo[] photos;
    Hashtable<String, Integer> categories = new Hashtable<>();

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();

            n_photos = Integer.valueOf(line);
            photos = new Photo[n_photos];

            for (int i = 0; i < n_photos; ++i) {
                line = br.readLine();
                photos[i] = new Photo(i, line, categories);
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
    }

    public long countV(){
        return Arrays.stream(photos).map(x -> x.isHorizontal).filter(x -> !x).count();
    }
    public long countH(){
        return Arrays.stream(photos).map(x -> x.isHorizontal).filter(x -> x).count();
    }
    public int countTags(){
        return categories.size();
    }

}
