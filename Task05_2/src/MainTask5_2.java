public class MainTask5_2 {
    public static void main(String[] args) {
        CompareTextFiles compareTextFiles = new CompareTextFiles();
        compareTextFiles.getEqualWords(args[0],args[1]);
        compareTextFiles.writeResultToFile("out.txt");
    }
}
