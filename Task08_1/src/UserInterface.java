import java.util.Scanner;

public class UserInterface {
    private BaseGroups base = new BaseGroups();
    private String fileBase;

    public UserInterface(String fileBase) {
        this.fileBase = fileBase;
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int numberMenu;
        do {
            System.out.println("*** Main menu ***");
            System.out.println("1. Create base");
            System.out.println("2. Display base");
            System.out.println("3. Edit base");
            System.out.println("4. Exit");
            System.out.print("Enter the menu item number: ");
            String number = sc.nextLine();
            try {
                numberMenu = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("Input format error");
                numberMenu = 0;
            }
            switch (numberMenu) {
                case 1:
                    System.out.println("# Create base #");
                    base = createBase();
                    saveBaseUI(base, fileBase);
                    break;
                case 2:
                    System.out.println("# Display base #");
                    base = base.readBase(fileBase);
                    try {
                        base.printBase();
                    } catch (NullPointerException e) {
                        System.out.println("File database not exit, create it");
                    }
                    break;
                case 3:
                    System.out.println("# Edit base #");
                    editBaseUI(base, fileBase);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("There is no such menu item, repeat input");
            }
        } while (true);
    }

    private BaseGroups createBase() {
        Student student;
        Group group;
        BaseGroups baseGroups = new BaseGroups();
        do {
            group = addGroupUI();
            if (group == null) break;
            else {
                do {
                    student = addStudentUI();
                    if (student == null) break;
                    else group.addStudent(student);
                } while (true);
                baseGroups.addToBase(group);
            }

        } while (true);
        return baseGroups;
    }

    private Group addGroupUI() {
        String groupName;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Add new group? (y/n): ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("n")) break;
            else if (ans.equalsIgnoreCase("y")) {
                System.out.print("Enter name group: ");
                groupName = sc.nextLine();
                return new Group(groupName);

            } else System.out.println("Repeat the answer");
        } while (true);
        return null;
    }

    private Student addStudentUI() {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        Sex sex;
        do {
            System.out.print("Add student to group? (y/n): ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("n")) break;
            else if (ans.equalsIgnoreCase("y")) {
                System.out.print("Enter name student: ");
                name = sc.nextLine();
                do {
                    try {
                        System.out.print("Enter age student: ");
                        String ageString = sc.nextLine();
                        age = Integer.parseInt(ageString);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input format error");
                    }
                } while (true);
                do {
                    try {
                        System.out.print("Enter sex student (M or F): ");
                        String sexString = sc.nextLine();
                        if (sexString.equalsIgnoreCase("M")) sex = Sex.MALE;
                        else if (sexString.equalsIgnoreCase("F")) sex = Sex.FEMALE;
                        else throw new IllegalArgumentException();
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Input format error");
                    }
                } while (true);
                return new Student(name, age, sex);
            } else System.out.println("Repeat the answer");
        } while (true);
        return null;
    }

    private void removeStudentIndexUI(Group group) {
        int index;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter index of student in group: ");
                index = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input format error");
            }
        } while (true);
        if (index <= group.getGroup().length) group.removeStudentIndex(index);
        else System.out.println("The student of this index do not exist");
    }

    private void saveBaseUI(BaseGroups base, String fileBase) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Do you save the base? (y/n): ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase("n")) break;
            else if (ans.equalsIgnoreCase("y")) {
                base.writeBase(base, fileBase);
                break;
            }
        } while (true);
    }

    private void editBaseUI(BaseGroups base, String fileBase) {
        boolean incoming = false;
        int numberOperation;
        Scanner sc = new Scanner(System.in);
        base = base.readBase(fileBase);
        try {
            base.printBase();
            System.out.print("Enter edit group (if not exist, will be create): ");
            String groupEdit = sc.nextLine();
            for (Group group : base.getListGroups()) {
                if (groupEdit.equalsIgnoreCase(group.getGroupName())) {
                    incoming = true;
                    do {
                        try {
                            System.out.print("Enter operation (1 - add student, 2 - remove student): ");
                            numberOperation = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Input format error");
                            numberOperation = -1;
                        }
                        if (numberOperation == -1 || numberOperation < 1 || numberOperation > 2) continue;
                        break;
                    } while (true);
                    if (numberOperation == 1) {
                        group.addStudent(addStudentUI());
                        break;
                    }
                    if (numberOperation == 2) {
                        removeStudentIndexUI(group);
                        break;
                    }
                }
            }
             if(!incoming) base.addToBase(new Group(groupEdit));
            base.writeBase(base, fileBase);
        } catch (NullPointerException e) {
            System.out.println("File database not exit, create it");
        }
    }
}