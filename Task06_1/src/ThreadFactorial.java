import java.math.BigInteger;

public  class ThreadFactorial implements Runnable {
    private int n;

    public ThreadFactorial(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public static BigInteger factorial(int n) {
        if (n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n - 1)) ;
    }

    @Override
    public void run() {
        factorial(n);
        System.out.println("Factorial " + n + " = " + factorial(n));
    }

}


