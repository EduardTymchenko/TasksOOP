import java.io.IOException;

public class MainTask113 {
    public static void main(String[] args) throws IOException {
        LinksHtml linksHtml = new LinksHtml("https://prog.kiev.ua/forum/index.php/topic,3928.75.html");
        linksHtml.writeToFile("links.txt");
    }
}
