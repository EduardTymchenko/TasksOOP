import java.io.Serializable;

public class Group implements Serializable {
    private static final long serialVersionUID = 13L;
    private String groupName;
    private Student[] group;

    public Group(String groupName) {
        this.groupName = groupName;
        group = new Student[0];
    }

    public String getGroupName() {
        return groupName;
    }

    public Student[] getGroup() {
        return group;
    }

    public void addStudent(Student student){
        Student[] tmp = new Student[group.length + 1];
        System.arraycopy(group,0,tmp,0,group.length);
        tmp[tmp.length - 1] = student;
        group = tmp;
    }

    public void removeStudentIndex(int index){
        Student[] tmp = new Student[group.length - 1];
        System.arraycopy(group,0,tmp,0, index - 1);
        System.arraycopy(group,index,tmp,index - 1,group.length - index);
        group = tmp;
    }

    public void printGroup(){
        int number = 1;
        System.out.println("Name group: " + groupName);
        for(Student item : group){
            System.out.println(number++ + ". " + item);
        }
    }

}
