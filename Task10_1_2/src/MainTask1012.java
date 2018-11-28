public class MainTask1012 {
    public static void main(String[] args) {
        String inFileName = "English.in";
        String outFileName = "Ukrainian.out";
        Dictionary dic = new Dictionary();

        dic.loadDictionary();
        dic.addWords("star","звезда");
        dic.saveDictionary();
        dic.readInFile(inFileName);
        dic.translate();
        dic.writeOutFile(outFileName);





    }
}
