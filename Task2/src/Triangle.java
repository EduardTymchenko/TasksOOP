/*
Создайте классы которые описывают как минимум 3
геометрические фигуры (они должны быть подклассами Shape),
при этом они вкачестве свойств должны содержать классы  Point.
 */
public class Triangle extends Shape{
    private Point a;
    private Point b;
    private Point c;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point a, Point b, Point c) {
        // проверка существования треугольника
        this.a = a;
        this.b = b;
        this.c = c;
        sideA = Math.sqrt(Math.pow((b.getX() - a.getX()),2) + Math.pow((b.getY() - a.getY()),2));
        sideB = Math.sqrt(Math.pow((c.getX() - b.getX()),2) + Math.pow((c.getY() - b.getY()),2));
        sideC = Math.sqrt(Math.pow((c.getX() - a.getX()),2) + Math.pow((c.getY() - a.getY()),2));
    }

    private boolean triangleOk(){
        if((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideC + sideB <= sideA)) return false;
        return true;
    }

    @Override
    public double getPerimetr() {
        if (!triangleOk()){
            System.out.println("The Triangle does not exist!");
            return 0;
        }
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double halfPerimetr = 0.5 * getPerimetr();
        return Math.sqrt(halfPerimetr * (halfPerimetr - sideA) * (halfPerimetr - sideB) * (halfPerimetr - sideC));
    }
}
