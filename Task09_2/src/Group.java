import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public void printGroup(){
        int number = 1;
        System.out.println("Name group: " + groupName);
        for(Student item : group){
            System.out.println(number++ + ". " + item);
        }
    }

}
