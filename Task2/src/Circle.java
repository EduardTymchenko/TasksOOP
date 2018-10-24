/*
Создайте классы которые описывают как минимум 3
геометрические фигуры (они должны быть подклассами Shape),
при этом они вкачестве свойств должны содержать классы  Point.
 */
public class Circle extends Shape{
    private Point centerPoint;
    private Point radiusPoint;
    private double lengthRadius;

    public Circle(Point centerPoint, Point radiusPoint) {
        this.centerPoint = centerPoint;
        this.radiusPoint = radiusPoint;
        lengthRadius = Math.sqrt(Math.pow((radiusPoint.getX() - centerPoint.getX()),2) +
                Math.pow((radiusPoint.getY() - centerPoint.getY()),2));
    }


    @Override
    public double getPerimetr() {
        if (lengthRadius == 0) System.out.println("The Circle does not exist!");
        return 2 * Math.PI * lengthRadius ;
    }

    @Override
    public double getArea() {
        if (lengthRadius == 0) System.out.println("The Circle does not exist!");
        return Math.PI * lengthRadius * lengthRadius;
    }
}
