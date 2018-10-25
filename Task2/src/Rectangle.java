/*
Создайте классы которые описывают как минимум 3
геометрические фигуры (они должны быть подклассами Shape),
при этом они вкачестве свойств должны содержать классы  Point.
 */
public class Rectangle extends Shape{
    private Point a;
    private Point b;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    // diagonal for checking the existence of a rectangle
    public boolean checkShape(){
        if(getLine(a,b) == 0){
            System.out.println("! The Rectangle does not exist!");
            return false;
        }
        return true;

    }

    @Override
    public double getPerimetr() {
        if (checkShape()) return ((b.getY() - a.getY()) + (b.getX() - a.getX())) * 2 ;
        else return -1;
    }

    @Override
    public double getArea() {
        if (checkShape()) return (b.getY() - a.getY()) * (b.getX() - a.getX());
        else return -1;
    }
}
