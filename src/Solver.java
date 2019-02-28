import java.io.BufferedReader;
import java.io.FileReader;

public class Solver {

    public Solver(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            String[] parsed_line = line.trim().split("\\s+");
//            R = Integer.valueOf(parsed_line[0]);
//            C = Integer.valueOf(parsed_line[1]);
//            L = Integer.valueOf(parsed_line[2]);
//            H = Integer.valueOf(parsed_line[3]);

//            grid = new int[R][C];
            int count = 0, i,j;
            while (line != null) {
                line = br.readLine();
//                for (char ch: line.toCharArray()){
//                    i = count / C;
//                    j = count % C;
//                    switch (ch){
//                        case 'T':
//                            grid[i][j] = TOMATO;
//                            break;
//                        case 'M':
//                            grid[i][j] = MUSHROOM;
//                            break;
//                        default:
//                            System.err.println("Error in pizza file");
//                            break;
//                    }
                    ++count;
//                }
            }
        } catch (Exception e) {
            System.err.println("Error reading the file " + filepath);
        }
    }
}
