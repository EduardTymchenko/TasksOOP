import java.util.Arrays;

public class MainTask09SAPI2 {
    public static void main(String[] args) {
        int[] arrayInt = { 5, -7, 4, -2, 1, 5, 3, -8, -4, -1};
        int rezPositive = Arrays.stream(arrayInt).filter(n -> n >= 0).min().getAsInt();
        int rezNegative = Arrays.stream(arrayInt).filter(n -> n < 0).max().getAsInt();
        System.out.println(rezNegative);
        System.out.println(rezPositive);
        System.out.println("------");

        if (rezPositive <= Math.abs(rezNegative)) System.out.println(rezPositive);
        else System.out.println(rezNegative);
    }
}
