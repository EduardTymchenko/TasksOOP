public class MainTask09_3 {
    public static void main(String[] args) {
        String fileName = "english.txt";
        TextAnalysis textAnalysis = new TextAnalysis();
        textAnalysis.readTextFromFile(fileName);

        System.out.println(textAnalysis.relativeRepetitionRate(textAnalysis.parsingString(" ",".",",","<>",";","-")));
    }
}
