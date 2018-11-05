/*
Task3:
    Создайте класс группа — который содержит массив из 10 объектов класса студент.
    Реализуйте методы добавления, удаления студента и метод поиска студента по фамилии.
    В случае попытки добавления 11 студента создайте собственное исключение и обработайте его.
    Определите метод toString() для группы так, что бы он выводил список студентов в алфавитном порядке.
Task4:
    1. Усовершенствуйте класс Group (Task3) добавив возможность интерактивного добавления объекта.
    2. Реализуйте возможность сортировки списка студентов по фамилии.
    3. Реализуйте возможность сортировки по параметру (Фамилия, успеваемость и т. д.).
    4. Реализуйте интерфейс Военком которые вернет из группы массив студентов юношей которым больше 18 лет.
    5. Протестируйте ее работу.*/
import java.util.Arrays;
import java.util.Scanner;

public class Group implements MilitaryCommissar{
    private Student[] groupStudents = new Student[10];

    public String sort(int columnNumber){
        StringBuilder sb = new StringBuilder();
        Student[] sortGroup = new Student[groupStudents.length];
        int count = 0;
        System.arraycopy(groupStudents, 0, sortGroup, 0, groupStudents.length);
        sb.append(Student.HEADER);
        try {
            switch (columnNumber) {
                case 1:
                    Arrays.sort(sortGroup, Student.ticketComparator);
                    break;
                case 2:
                    Arrays.sort(sortGroup, Student.firstNameComparator);
                    break;
                case 3:
                    Arrays.sort(sortGroup, Student.familyNameComparator);
                    break;
                case 4:
                    Arrays.sort(sortGroup, Student.ageComparator);
                    break;
                case 5:
                    Arrays.sort(sortGroup, Student.sexComparator);
                    break;
                case 6:
                    Arrays.sort(sortGroup, Student.nationalityComparator);
                    break;
                default:
                    System.out.println("Not correct column number!");
            }
        }catch (NullPointerException e) {
            System.out.println("Exception Arrays.sort: " + e.getMessage());
        }
        for (Student item : sortGroup) {
            if (item != null) {
                sb.append(item.toString());
                count++;
            }
        }
        if (count == 0) return "The group has not item!";
        return sb.toString();
    }

    public void addStudentInteractive() throws NoSuchFieldException {
        Scanner sc = new Scanner(System.in);
        int age;
        int ticket;
        String sex;

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Family Name: ");
        String familyName = sc.nextLine();
        do {
            System.out.print("Enter Age (integer): ");
            String ageString = sc.nextLine();
            try {
                age = Integer.parseInt(ageString);
                if (age < 16 || age > 65) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Wrong data, repeat enter");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("Enter Sex (MALE or FEMALE): ");
            sex = sc.nextLine();
            if (sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female")) {
                sex = sex.toUpperCase();
                break;
            } else System.out.println("Wrong data, repeat enter");
        } while (true);
        System.out.print("Enter Nationality: ");
        String nationality = sc.nextLine();
        do {
            System.out.print("Enter number student Ticket(integer): ");
            String ticketString = sc.nextLine();
            try {
                ticket = Integer.parseInt(ticketString);
            } catch (NumberFormatException e) {
                System.out.println("Wrong data, repeat enter");
                continue;
            }
            break;
        } while (true);
        Student newStudent = new Student(firstName, familyName, age, Sex.valueOf(sex), nationality, ticket);
        add(newStudent);
    }

    public void add(Student student) throws NoSuchFieldException {
        for (int i = 0; i < groupStudents.length; i++) {
            if (groupStudents[i] == null) {
                groupStudents[i] = student;
                System.out.println("Student added to group");
                return;
            }
        }
        throw new NoSuchFieldException("Add 11th element");
    }
    //first incoming of last name
    public void remove(String familyName) {
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i] != null) && (groupStudents[i].getFamilyName() == familyName)) {
                System.out.println("The student " + groupStudents[i].getFamilyName() + " removed!");
                System.arraycopy(groupStudents, i + 1, groupStudents, i, groupStudents.length - (i + 1));
                groupStudents[groupStudents.length - 1] = null;
                return;
            }
        }
        System.out.println("The student " + familyName + " do not found!");
    }

    public void removeAll(String familyName) {
        int count = 0;
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i - count] != null) && (groupStudents[i - count].getFamilyName() == familyName)) {
                    System.arraycopy(groupStudents, i + 1 - count, groupStudents, i - count,
                            groupStudents.length - (i + 1 - count));
                    groupStudents[groupStudents.length - 1] = null;
                    count++;
            }
        }
        if (count == 0) System.out.println("The student " + familyName + " do not found!");
        else  System.out.println("Students " + familyName + " removed!\nRemoved " + count +" records");
    }

    public String search(String familyName) {
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i] != null) && (groupStudents[i].getFamilyName() == familyName))
                return Student.HEADER + groupStudents[i].toString();
        }
        return "The student by last name " + familyName + " not found.";
    }

    public String searchAll(String familyName) {
        StringBuilder searchAll = new StringBuilder();
        int count = 0;
        searchAll.append(Student.HEADER);
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i] != null) && (groupStudents[i].getFamilyName() == familyName)) {
                searchAll.append(groupStudents[i].toString());
                count++;
            }
        }
        if (count == 0) return searchAll.append("Students by last name " + familyName + " not found.").toString();
        return searchAll.toString();
    }

    @Override
    public String toString() {
        Student[] sortGroup = new Student[groupStudents.length];
        StringBuilder stringGroupe = new StringBuilder();
        int count = 0;
        stringGroupe.append(Student.HEADER);
        System.arraycopy(groupStudents, 0, sortGroup, 0, groupStudents.length);
        try {
            Arrays.sort(sortGroup);
        } catch (NullPointerException e) {
            System.out.println("Exception Arrays.sort: " + e.getMessage());
        }
        for (Student item : sortGroup) {
            if (item != null) {
                stringGroupe.append(item.toString());
                count++;
            }
        }
        if (count == 0) return "The group has not item!";
        return stringGroupe.toString();
    }

    @Override
    public Student[] getRecruits() {
        Student[] recruits = new Student[groupStudents.length];
        int count = 0;
        for (Student item : groupStudents) {
            if (item != null && item.getAge() >= 18 && item.getSex() == Sex.MALE) {
                recruits[count] = item;
                count++;
            }
        }
        return recruits;
    }
}
