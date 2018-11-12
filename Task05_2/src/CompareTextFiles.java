import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CompareTextFiles {
    private HashSet<String> listOut = new HashSet();

    public HashSet<String> getEqualWords(String nameFile1, String nameFile2) {
        String pathFile1 = "Task05_2/files/" + nameFile1;
        String pathFile2 = "Task05_2/files/" + nameFile2;
        // get identical words
        for (String word : getWordOfFile(pathFile1)) {
            if (getWordOfFile(pathFile2).contains(word)) listOut.add(word);
        }
        return listOut;
    }
        // write to the file
    public void  writeResultToFile (String nameOutFile){
        if (listOut.isEmpty()) System.out.println("No identical words");

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(checkOutputFile(nameOutFile)))) {
            for (String word : listOut) {
                fileWriter.write(word + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File checkOutputFile(String nameFile) {
        File file = new File("Task05_2/files/" + nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Out file not exist and not create " + e.getMessage());
                System.exit(1);
            }
        }
        return file;
    }

    // choose only unique words
    private HashSet<String> getWordOfFile(String path) {
        HashSet<String> listWords = new HashSet<String>();
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(path));
            String currentLine = readFile.readLine();
            StringTokenizer st;
            while (currentLine != null) {
                st = new StringTokenizer(currentLine, " \t\n\r,.");
                while (st.hasMoreTokens()) {
                    listWords.add(st.nextToken());
                }
                currentLine = readFile.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found " + e.getMessage());
            System.exit(1);

        } catch (IOException e) {
            System.out.println("Input file not reading  " + e.getMessage());
            System.exit(1);
        }
        return listWords;
    }
}
