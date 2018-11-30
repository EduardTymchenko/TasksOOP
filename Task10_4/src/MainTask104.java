import java.util.Scanner;

public class MainTask104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        ArtText artText = new ArtText("art.txt",7,7);
        artText.printArt(text);

    }
}
