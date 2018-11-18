public class MainTask09_2 {
    public static void main(String[] args) {
        Group group1 = new Group("PE - 41");
        group1.addStudent(new Student("Name1", 18, Sex.MALE));
        group1.addStudent(new Student("Name2", 19, Sex.FEMALE));
        group1.addStudent(new Student("Name3", 18, Sex.FEMALE));
        group1.addStudent(new Student("Name4", 18, Sex.MALE));
        group1.addStudent(new Student("Name5", 18, Sex.MALE));
        group1.printGroup();

        group1.removeStudentIndex(4);
        group1.printGroup();
    }
}
