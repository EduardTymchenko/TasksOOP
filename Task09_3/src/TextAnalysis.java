import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextAnalysis {
    private String text;

    public TextAnalysis(String text) {
        this.text = text;
    }

    public TextAnalysis() {
    }

    public String getText() {
        return text;
    }

    public void readTextFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Task09_3/" + fileName))) {
            StringBuilder line = new StringBuilder();
            String currenLine;
            while ((currenLine = reader.readLine()) != null) {
                line.append(currenLine);
                line.append(" ");
            }
            text = line.toString();
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
    }

    public String parsingString(String... delSymbols) {
        String[] arrayDel = delSymbols;
        if (arrayDel.length == 0) return text;
        return text.replaceAll(Arrays.toString(arrayDel), "");
    }

    public List<MyMap> relativeRepetitionRate(String inputText) {
        if (inputText.length() == 0) return null;
        List<MyMap> rezult = new ArrayList<>();
        inputText = inputText.toLowerCase();
        List<Character> arrayChar = new ArrayList<>();
        for (char ch : inputText.toCharArray()) {
            arrayChar.add(ch);
        }
        char curentChar;
        for (int i = 0; i < arrayChar.size(); i++) {
            curentChar = arrayChar.get(0);
            arrayChar.remove(0);
            i--;
            double count = 1;
            for (int j = 0; j < arrayChar.size(); j++) {
                if (curentChar == arrayChar.get(j)) {
                    count++;
                    arrayChar.remove(j);
                    j--;
                }
            }
            rezult.add(new MyMap(curentChar, count / text.length()));
        }
        Collections.sort(rezult, Collections.reverseOrder());
        return rezult;
    }


}
