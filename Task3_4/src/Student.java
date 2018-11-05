/*
На его основе класса человека создайте класс студент (переопределите метод вывода информации)
*/
import java.util.Comparator;
public class Student extends Person implements Comparable{
    public static final String HEADER = "1.Ticket   2.First Name  3.Family Name  4.Age  5.Sex    6.Nationality\n";
    private int numberStudentTicket;
    public Student(String firstName, String familyName, int age, Sex sex, String nationality, int numberStudentTicket) {
        super(firstName, familyName, age, sex, nationality);
        this.numberStudentTicket = numberStudentTicket;
    }

    public int getNumberStudentTicket() {
        return numberStudentTicket;
    }

    public void setNumberStudentTicket(int numberStudentTicket) {
        this.numberStudentTicket = numberStudentTicket;
    }

    @Override
    public String toString() {
            return String.format("%-11s", getNumberStudentTicket()) + String.format("%-14s", getFirstName()) +
                    String.format("%-15s", getFamilyName()) + String.format("%-7s", getAge()) + String.format("%-9s", getSex())
                    + String.format("%-13s", getNationality()) + "\n";
    }

    @Override
    public int compareTo(Object o) {
        Student tmp = (Student) o;
       return this.getFamilyName().compareTo(tmp.getFamilyName());
    }
    // sort by ticket number
    public static Comparator<Student> ticketComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getNumberStudentTicket() - o2.getNumberStudentTicket();
        }
    };
    // sort by First Name
    public static Comparator<Student> firstNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    };
    // sort by Family Name
    public static Comparator<Student> familyNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFamilyName().compareTo(o2.getFamilyName());
        }
    };
    // sort by Age
    public static Comparator<Student> ageComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    };
    // sort by Sex
    public static Comparator<Student> sexComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSex().toString().compareTo(o2.getSex().toString());
        }
    };
    // sort by Nationality
    public static Comparator<Student> nationalityComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getNationality().compareTo(o2.getNationality());
        }
    };




}
