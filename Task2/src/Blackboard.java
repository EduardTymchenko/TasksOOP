/*
—оздайте класс доска. ƒоска поделена на 4 части в каждую
часть доски можно положить одну из фигур. ” доски должны
быть методы которые помещают и удал€ют фигуру с доски.
“акже должен быть метод который выводит информацию о
всех фигурах лежащих на доске и их суммарную площадь.
 */
import java.util.Scanner;

public class Blackboard {
    private Shape shape;
    private Shape[] sections = new Shape[4];

    public void addShape(){
        Scanner sc = new Scanner(System.in);
        String nameShape;
        int numberSection;
        boolean stop = false;
        System.out.println("*** Add shape ***");
        do {
            System.out.print("Enter shape (circle, rectangle or triangle): ");
            nameShape = sc.nextLine();
            switch (nameShape.toLowerCase().trim()){
                case "circle":
                    System.out.print("Enter center X (double): ");
                    double centerX = sc.nextDouble();
                    System.out.print("Enter center Y (double): ");
                    double centerY = sc.nextDouble();
                    System.out.print("Enter radius X (double): ");
                    double radiusX = sc.nextDouble();
                    System.out.print("Enter radius Y (double): ");
                    double radiusY = sc.nextDouble();
                    shape = new Circle(new Point(centerX,centerY),new Point(radiusX,radiusY));
                    if (!shape.checkShape()) shape = null;
                    stop = true;
                    break;
                case "rectangle":
                    System.out.print("Enter start top rectangle X(double): ");
                    double startTopX = sc.nextDouble();
                    System.out.print("Enter start top rectangle Y(double): ");
                    double startTopY = sc.nextDouble();
                    System.out.print("Enter vertex of the rectangle diagonally X (double): ");
                    double endTopX = sc.nextDouble();
                    System.out.print("Enter vertex of the rectangle diagonally Y (double): ");
                    double endTopY = sc.nextDouble();
                    shape = new Rectangle(new Point(startTopX,startTopY),new Point(endTopX,endTopY));
                    if (!shape.checkShape()) shape = null;
                    stop = true;
                    break;
                case "triangle":
                    System.out.print("Enter X for triangle top A(double): ");
                    double aX = sc.nextDouble();
                    System.out.print("Enter Y for triangle top A(double): ");
                    double aY = sc.nextDouble();
                    System.out.print("Enter X for triangle top B(double): ");
                    double bX = sc.nextDouble();
                    System.out.print("Enter Y for triangle top B(double): ");
                    double bY = sc.nextDouble();
                    System.out.print("Enter X for triangle top C(double): ");
                    double cX = sc.nextDouble();
                    System.out.print("Enter Y for triangle top C(double): ");
                    double cY = sc.nextDouble();
                    shape = new Triangle(new Point(aX,aY),new Point(bX,bY),new Point(cX,cY));
                    if (!shape.checkShape()) shape = null;
                    stop = true;
                    break;
            }
        }while (!stop);

        do {
            System.out.print("Enter section to add (1-4)(exit 0): ");
            numberSection = sc.nextInt();
            if (numberSection >=1 && numberSection <= 4) {
                if (sections[numberSection - 1] == null) break;
                else System.out.println("section is busy");
            }
            if (numberSection == 0) break;
        }while (true);

        if (numberSection != 0){
            sections[numberSection - 1] = shape;
            System.out.println("Shape is added");
        } else {
            System.out.println("Shape is not added, enter EXIT");
        }
    }

    public void delShape(){
        Scanner sc = new Scanner(System.in);
        int numberSection;
        System.out.println("*** Remove shape ***");
        do {
            System.out.print("Enter section to remove shape (1-4)(exit 0): ");
            numberSection = sc.nextInt();
        }while (numberSection < 0 || numberSection > 4);
        if (numberSection !=0) {
            sections[numberSection - 1] = null;
            System.out.println("Shape is delete from section " + (numberSection));
        }else{
            System.out.println("Exit from the method to remove a figure");
        }
    }
    public void info(){
        int i = 1;
        double sumArea = 0;
        String className;
        System.out.println("*** Info blackboard ***");
        for (Shape shape: sections){
            if (shape != null){
                className = shape.getClass().getName();
                sumArea += shape.getArea();
            } else {
                className = "None";
            }
            System.out.println("For " + i + " section is shape - " + className);
            i++;
        }
        System.out.println("Shapes total area is: " + sumArea);
    }


    public static void main(String[] args) {
        Blackboard blackboard = new Blackboard();
        Scanner sc = new Scanner(System.in);
        String ans;
        do {
            blackboard.addShape();
            blackboard.delShape();
            blackboard.info();
            System.out.print("Do you want to continue? (y/n): ");
            ans = sc.next();
            if (ans.equalsIgnoreCase("n")) break;
        }while (true);
        System.out.println("------------------------");
    }
}
