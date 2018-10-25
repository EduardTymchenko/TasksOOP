/*
Создайте классы которые описывают как минимум 3
геометрические фигуры (они должны быть подклассами Shape),
при этом они вкачестве свойств должны содержать классы  Point.
 */
public class Circle extends Shape{
    private Point centerPoint;
    private Point radiusPoint;

    public Circle(Point centerPoint, Point radiusPoint) {
        this.centerPoint = centerPoint;
        this.radiusPoint = radiusPoint;
    }

    public boolean checkShape(){
        if(getLine(centerPoint,radiusPoint) == 0){
            System.out.println("! The Circle does not exist!");
            return false;
        }
        return true;
    }

    @Override
    public double getPerimetr() {
        if (checkShape()) return 2 * Math.PI * getLine(centerPoint,radiusPoint);
        return  -1;
    }

    @Override
    public double getArea() {
        if (checkShape()) return Math.PI * Math.pow(getLine(centerPoint,radiusPoint),2);
        return -1;
    }
}
