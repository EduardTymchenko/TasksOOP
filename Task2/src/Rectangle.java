/*
�������� ������ ������� ��������� ��� ������� 3
�������������� ������ (��� ������ ���� ����������� Shape),
��� ���� ��� ��������� ������� ������ ��������� ������  Point.
 */
public class Rectangle extends Shape{
    private Point a;
    private Point b;
    private double sideA;
    private double sideB;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
        sideA = b.getY() - a.getY();
        sideB = b.getX() - a.getX();
    }


    @Override
    public double getPerimetr() {
        if (sideA == 0 || sideB == 0) {
            System.out.println("The rectangle does not exist!");
            return 0;
        }
        return (sideA + sideB) * 2 ;
    }

    @Override
    public double getArea() {
        if (sideA == 0 || sideB == 0) System.out.println("The rectangle does not exist!");
        return sideA * sideB;
    }
}
