import java.util.Scanner;

public class Task09SAPI1 {
    public static void main(String[] args) {
        Group group1 = new Group("PE - 41");
        group1.addStudent(new Student("ALEX", 18, Sex.MALE));
        group1.addStudent(new Student("LUCY", 19, Sex.FEMALE));
        group1.addStudent(new Student("ROSIE", 18, Sex.FEMALE));
        group1.addStudent(new Student("JACK", 18, Sex.MALE));
        group1.addStudent(new Student("RYAN", 18, Sex.MALE));
        group1.printGroup();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first letter of name: ");
        String letter = sc.next();
        group1.letterStudents(letter);

    }
}
