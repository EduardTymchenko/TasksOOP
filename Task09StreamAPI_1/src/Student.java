import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID = 13L;
    private String name ;
    private int age;
    private Sex sex;

    public Student(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return (" Name - " + name + ", Age - " + age + ", Sex - " + sex.toString());
    }
}
