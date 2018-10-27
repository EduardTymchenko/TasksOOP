
public class MainTask3 {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan","Ivanov",18,Sex.MALE,"Ukraine");
        System.out.println("toString() for class Person:");
        System.out.println(person1.toString());

        Student student1 = new Student("Nikolay","Marchenko",
                19,Sex.MALE,"Ukraine",1234);
        System.out.println("toString() for class Student:");
        System.out.println(Student.HEADER + student1.toString());
        Student student2 = new Student("Alex","Bubko",
                18,Sex.MALE,"Ukraine",2345);
        Student student3 = new Student("Juli","Avrameko",
                18,Sex.FEMALE,"Ukraine",3456);
        Student student4 = new Student("Evgen","Murasko",
                18,Sex.MALE,"Ukraine",4567);
        Student student5 = new Student("Naday","Murasko",
                18,Sex.FEMALE,"Ukraine",5678);
        Student student6 = new Student("Naday","Mironenko",
                18,Sex.FEMALE,"Ukraine",6789);
        Group group = new Group();
        try {
            group.add(student1);
            group.add(student2);
            group.add(student3);
            group.add(student4);
            group.add(student5);
            group.add(student6);
            group.add(student1);
            group.add(student1);
            group.add(student1);
            group.add(student1);
            group.add(student5);
        } catch (Exception e) {
            System.out.println("*Exception*");
            System.out.println("*This group is full! \n*Students can not add!");

        }
        System.out.println(group.toString());
        System.out.println("Method search():\n" + group.search("Marchenko"));
        System.out.println("Method searchAll():\n" + group.searchAll("Murasko") );
        System.out.println("Method remove:");
        group.remove("Marchenko");
        System.out.println(group.toString());
        System.out.println("Method removeAll:");
        group.removeAll("Marchenko");
        System.out.println(group.toString());
    }
}
