import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File directory = new File("dir");
        File file = new File(directory, "Names.txt");
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            char[] array = new char[128]; // читать будем целым массивом (размер 128 байт)
            int count = reader.read(array);
            StringBuilder res = new StringBuilder();
            while (count > 0) {
                res.append(new String(array, 0, count));
                count = reader.read(array);
            }
            String[] names = res.toString().split(",");
            Arrays.stream(names)
                    .filter(name -> name.startsWith("M"))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
