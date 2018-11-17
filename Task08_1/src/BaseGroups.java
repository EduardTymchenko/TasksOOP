import java.io.*;

public class BaseGroups implements Serializable{
    private static final long serialVersionUID = 13L;
    private Group[] listGroups;

    public BaseGroups() {
        listGroups = new Group[0];
    }

    public Group[] getListGroups() {
        return listGroups;
    }

    public void addToBase(Group newGroup) {
        Group[] tmp = new Group[listGroups.length + 1];
        System.arraycopy(listGroups,0,tmp,0,listGroups.length);
        tmp[tmp.length - 1] = newGroup;
        listGroups = tmp;
    }

    public BaseGroups readBase(String nameBase) {
        String pathBase = "Task08_1/" + nameBase;
        BaseGroups groups = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathBase))) {
            groups = (BaseGroups) ois.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return groups;
    }
    public void writeBase(BaseGroups nameBase, String fileName) {
        String pathBase = "Task08_1/" + fileName;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathBase))) {
            oos.writeObject(nameBase);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void printBase() {
        System.out.println("*************Base**************");
        for (Group item : listGroups) {
            item.printGroup();
        }

    }


}
