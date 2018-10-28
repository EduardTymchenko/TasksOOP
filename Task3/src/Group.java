/*
Создайте класс группа — который содержит массив из 10 объектов класса студент.
Реализуйте методы добавления, удаления студента и метод поиска студента по фамилии.
В случае попытки добавления 11 студента создайте собственное исключение и обработайте его.
Определите метод toString() для группы так, что бы он выводил список студентов в алфавитном порядке.
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
    //first incoming of last name
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
        int count = 0;
        for (int i = 0; i < groupStudents.length; i++) {
            if ((groupStudents[i - count] != null) && (groupStudents[i - count].getFamilyName() == familyName)) {
                    System.arraycopy(groupStudents, i + 1 - count, groupStudents, i - count,
                            groupStudents.length - (i + 1 - count));
                    groupStudents[groupStudents.length - 1] = null;
                    count++;
            }
        }
        if (count == 0) System.out.println("The student " + familyName + " do not found!");
        else  System.out.println("Students " + familyName + " removed!\nRemoved " + count +" records");
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
