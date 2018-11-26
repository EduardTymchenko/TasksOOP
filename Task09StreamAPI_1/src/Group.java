import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Group implements Serializable {
    private static final long serialVersionUID = 13L;
    private String groupName;
    private List<Student> group;

    public Group(String groupName) {
        this.groupName = groupName;
        group = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getGroup() {
        return group;
    }

    public void addStudent(Student student){
        group.add(student);
    }

    public void removeStudentIndex(int index){
        group.remove(--index);
    }

    public void letterStudents (String firstLetter){
        char letter = firstLetter.toLowerCase().charAt(0);
        int number = 1;
        List<Student> letterGroup = group.stream().filter(n -> n.getName().toLowerCase().charAt(0) == letter).collect(Collectors.toList());
        if (letterGroup.size() == 0) {
            System.out.println("The list is empty");
            return;
        }
        for(Student item : letterGroup){
            System.out.println(number++ + ". " + item);
        }
    }

    public void printGroup(){
        int number = 1;
        System.out.println("Name group: " + groupName);
        for(Student item : group){
            System.out.println(number++ + ". " + item);
        }
    }

}
