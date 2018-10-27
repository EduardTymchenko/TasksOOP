/*
�������� ����� ������ � ������� �������� ������ �� 10 �������� ������ �������.
���������� ������ ����������, �������� �������� � ����� ������ �������� �� �������.
� ������ ������� ���������� 11 �������� �������� ����������� ���������� � ����������� ���.
���������� ����� toString() ��� ������ ���, ��� �� �� ������� ������ ��������� � ���������� �������.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Group {
    private Student[] groupStudents = new Student[10];

    public void add(Student student) throws Exception {
        for (int i = 0; i < groupStudents.length; i++) {
            if (groupStudents[i] == null) {
                groupStudents[i] = student;
                System.out.println("Student added to group");
                return;
            }
        }
        throw new Exception("Add 11th element");
    }

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
        Scanner sc = new Scanner(System.in);
        String ans;
        int count = 0;
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i - count] != null) && (groupStudents[i - count].getFamilyName() == familyName)) {
                System.out.println(Student.HEADER + groupStudents[i - count].toString());
                System.out.print("Do you want to remove this student? (y/n): ");
                ans = sc.next();
                if (ans.equalsIgnoreCase("y")) {
                    System.out.println("The student " + groupStudents[i - count].getFamilyName() + " removed!");
                    System.arraycopy(groupStudents, i + 1 - count, groupStudents, i - count,
                            groupStudents.length - (i + 1 - count));
                    groupStudents[groupStudents.length - 1] = null;
                    count++;
                }
            }
        }
        if (count == 0) System.out.println("The student " + familyName + " do not found!");
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
}
