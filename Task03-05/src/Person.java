/*
Создайте класс описывающий человека (создайте метод выводящий информацию о человеке)
*/
public class Person {
    private String firstName;
    private String familyName;
    private int age;
    private Sex sex;
    private String nationality;

    public Person(String firstName, String familyName, int age, Sex sex, String nationality) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.age = age;
        this.sex = sex;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        System.out.println("Person");
        return "First name: " + getFirstName() + "\n" +
                "Family name: " + getFamilyName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Sex: " + getSex() + "\n" +
                "Nationality: " + getNationality() + "\n";
    }
}
