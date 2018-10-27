/*
На его основе класса человека создайте класс студент (переопределите метод вывода информации)
*/
public class Student extends Person implements Comparable{
    public static final String HEADER = "Ticket   First Name  Family Name  Age  Sex    Nationality\n";
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
            return String.format("%-9s", getNumberStudentTicket()) + String.format("%-12s", getFirstName()) +
                    String.format("%-13s", getFamilyName()) + String.format("%-5s", getAge()) + String.format("%-7s", getSex())
                    + String.format("%-11s", getNationality()) + "\n";
    }

    @Override
    public int compareTo(Object o) {
        Student tmp = (Student) o;
       return this.getFamilyName().compareTo(tmp.getFamilyName());
    }
}
