import java.util.Scanner;

public class MainTask08_2_3 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);

        myStack.addElement(new Integer(2));
        myStack.addElement(new Boolean(true));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new Scanner(System.in));
        System.out.println("### Stack:");
        while (!myStack.isEmty()) {
            System.out.println(myStack.getDeleleElement());
        }
        System.out.println("-------");
        myStack.getBlackList().addBL(String.class);

        myStack.addElement(new Integer(2));
        myStack.addElement(new Boolean(true));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new String("Hello"));
        myStack.addElement(new Scanner(System.in));
        System.out.println("#### Stack:");
        while (!myStack.isEmty()) {
            System.out.println(myStack.getDeleleElement());
        }
        System.out.println("-------");
    }
}
