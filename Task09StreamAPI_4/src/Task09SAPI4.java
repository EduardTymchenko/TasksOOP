import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task09SAPI4 {
    public static void main(String[] args) {
        String pattern = "[^0-9]+";
        try (BufferedReader br = new BufferedReader(new FileReader("Task09StreamAPI_4/numbers.txt"))) {
            StringBuilder stringBuilder = new StringBuilder();
            String str ;
            while ((str = br.readLine()) != null){
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }
            str = stringBuilder.toString().trim();

            int maxElement = Arrays.stream(str.split(pattern)).mapToInt(Integer::parseInt).max().getAsInt();
            System.out.println(maxElement);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
