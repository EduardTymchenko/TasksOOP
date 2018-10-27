/*
Создайте класс доска. Доска поделена на 4 части в каждую
часть доски можно положить одну из фигур. У доски должны
быть методы которые помещают и удаляют фигуру с доски.
Также должен быть метод который выводит информацию о
всех фигурах лежащих на доске и их суммарную площадь.
 */

public class Blackboard {
    private Shape[] sections = new Shape[4];

    public void addShape(Shape shape, int part){
        if (part < 1 || part > 4) {
            System.out.println("Part not correct, must be 1-4");
            return;
        }
        if (shape == null){
            System.out.println("Cannot add null object");
            return;
        }
        if (sections[part - 1] == null) {
            sections[part - 1] = shape;
            System.out.println(shape.getClass().getName() + " added to part " + part);
        }
        else System.out.println("Part is busy, select other");
    }

    public void delShape(int part){
        if (part < 1 || part > 4) {
            System.out.println("Part not correct, must be 1-4");
            return;
        }
        if (sections[part - 1] == null) System.out.println("Shape do not found in this part.");
        else {
            System.out.println(sections[part - 1].getClass().getName() + " removed of part " + part);
            sections[part - 1] = null;
        }
    }

    public void delAllShape(){
        for (int i = 0; i < sections.length; i++){
            sections[i] = null;
        }
        System.out.println("Blackboard is clean.");

    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        String nameShape;
        double sumArea = 0;
        for (int i = 0; i < sections.length; i++ ){
            if (sections[i] != null) {
                sumArea += sections[i].getArea();
                nameShape = sections[i].getClass().getName();
            } else nameShape = "NOT shape";

            info.append("There is " + nameShape + " in part " + (i + 1) + "\n");
        }
        info.append("Shapes total area is: " + sumArea);
        return info.toString();
    }

}
