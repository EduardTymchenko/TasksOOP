import java.util.Arrays;
import java.util.Scanner;

public class MainTask09SAPI3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string line: ");
        String string = sc.nextLine();
        int[] arrayASCII = string.chars().toArray();
        System.out.println(Arrays.toString(arrayASCII));
    }
}
