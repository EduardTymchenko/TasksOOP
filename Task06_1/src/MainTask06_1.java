public class MainTask06_1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            Thread thread = new Thread(new ThreadFactorial(i));
            thread.start();
        }
    }
}
