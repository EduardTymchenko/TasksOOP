import java.io.*;
import java.util.*;

public class Dictionary {

    private Map<String, String> vocabulary = new HashMap<>();
    private String inText;
    private String outText;

    public Dictionary() {
        defaultWords();
    }

    private void defaultWords() {
        vocabulary.put("who", "кто");
        vocabulary.put("uses", "использует");
        vocabulary.put("Internet", "Интернет");
        vocabulary.put("lot", "многие");
        vocabulary.put("a", "");
        vocabulary.put("of", "");
        vocabulary.put("use", "пользуются");
        vocabulary.put("every", "каждый");
        vocabulary.put("day", "день");
        vocabulary.put("among", "среди");
        vocabulary.put("those", "них");
        vocabulary.put("students", "студенты");
        vocabulary.put("and", "и");
        vocabulary.put("businesspeople", "бизнесмены");
        vocabulary.put("children", "дети");
        vocabulary.put("housewives", "домохозяйки");
        vocabulary.put("pensioners", "пенсионеры");
        vocabulary.put("pensioner", "пенсионер");
        vocabulary.put("teachers", "учителя");
        vocabulary.put("teacher", "учитель");
        vocabulary.put("people", "люди");
    }

    public void readInFile(String inFileName) {
        StringBuilder sb = new StringBuilder();
        String englishText;
        try (BufferedReader br = new BufferedReader(new FileReader("Task10_1_2/" + inFileName))) {
            while ((englishText = br.readLine()) != null) {
                sb.append(englishText);
                sb.append(System.lineSeparator());
            }
            inText = sb.toString();
        } catch (IOException e) {
            System.out.println("Error read file" + inFileName + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public void writeOutFile(String outFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Task10_1_2/" + outFileName))) {
            bw.write(outText);
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error write file" + outFileName + ": " + e.getMessage());
            System.exit(1);
        }
    }

    public void translate() {
        String patern = " ,;:.!?\n\r";
        String currentWord;
        String tmp;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(inText, patern, true);
        while (st.hasMoreTokens()) {
            currentWord = st.nextToken();
            if (vocabulary.containsKey(currentWord)) {
                sb.append(vocabulary.get(currentWord));
            } else if (vocabulary.containsKey(currentWord.toLowerCase())) {
                tmp = vocabulary.get(currentWord.toLowerCase());
                if (tmp == null || tmp.isEmpty()) tmp = "";
                else tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);
                sb.append(tmp);
            } else sb.append(currentWord);
        }
        outText = sb.toString();
    }

    public void addWords(String english, String translation) {
        Scanner sc = new Scanner(System.in);
        String ans;
        if (vocabulary.containsKey(english)){
            System.out.println("The word: " + english + " is in the dictionary and is translate as: " + vocabulary.get(english));
            do {
                System.out.print("Do you want to change the translation? (y/n)");
                ans = sc.next();
                if (ans.equalsIgnoreCase("n")) break;
                if (ans.equalsIgnoreCase("y")){
                    vocabulary.put(english,translation);
                    break;
                }
            }while (true);
        } else {
            vocabulary.put(english,translation);
        }
    }
    public void saveDictionary(){
        Properties properties = new Properties();
        for (Map.Entry<String,String> iteam : vocabulary.entrySet()){
            properties.put(iteam.getKey(),iteam.getValue());
        }
        try {
            properties.store(new FileWriter("Task10_1_2/dic.properties"),null);
        } catch (IOException e) {
            System.out.println("Error write file vocabulary: " + e.getMessage());
        }
    }
    public void loadDictionary(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("Task10_1_2/dic.properties"));
            for (String key : properties.stringPropertyNames()) {
                vocabulary.put(key, properties.get(key).toString());
            }
        } catch (IOException e) {
            System.out.println("Error read file vocabulary: " + e.getMessage());
            System.out.println("Loaded default vocabulary");
        }
    }

}
