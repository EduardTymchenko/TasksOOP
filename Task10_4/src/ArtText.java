import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArtText {
    private Map<Character, String[]> mapArt = new HashMap<>();
    private int numberLinesLetter;
    private int numberColumnsLetter;
    private String fileNameArt;

    public ArtText(String fileNameArt, int numberLinesLetter, int numberColumnsLetter) {
        this.numberLinesLetter = numberLinesLetter;
        this.numberColumnsLetter = numberColumnsLetter;
        this.fileNameArt = fileNameArt;
        readArtFile();
    }

    private void readArtFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("Task10_4/" + fileNameArt))) {
            int count = 0;
            String key = null;
            String[] artLetter = new String[numberLinesLetter];
            String line;
            while ((line = br.readLine()) != null) {
                if (count == 0) key = line;
                if (count > 0 && count <= numberLinesLetter) {
                    if (line.length() < numberColumnsLetter) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(line);
                        for (int i = 0; i < numberColumnsLetter - line.length(); i++) {
                            sb.append(" ");
                        }
                        line = sb.toString();
                    }
                    artLetter[count - 1] = line;
                }
                count++;
                if (count > numberLinesLetter) {
                    count = 0;
                    String[] letter = new String[artLetter.length];
                    System.arraycopy(artLetter, 0, letter, 0, artLetter.length);
                    mapArt.put(key.charAt(0), letter);
                }
            }
        } catch (IOException e) {
            System.out.println("Error read file: " + e.getMessage());
            System.exit(1);
        }
    }

    public void printArt(String inText) {
        inText = inText.toUpperCase();
        char[] arrayChar = inText.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberLinesLetter; i++) {
            for (char ch : arrayChar) {
                if (ch == ' ') {
                    for (int j = 0; j < numberColumnsLetter; j++) {
                        sb.append(" ");
                    }
                } else {
                    sb.append(mapArt.get(ch)[i]);
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
