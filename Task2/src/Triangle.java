/*
�������� ������ ������� ��������� ��� ������� 3
�������������� ������ (��� ������ ���� ����������� Shape),
��� ���� ��� ��������� ������� ������ ��������� ������  Point.
 */
public class Triangle extends Shape{
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean checkShape(){
        double sideA = getLine(a,b);
        double sideB = getLine(b,c);
        double sideC = getLine(a,c);
        if((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideC + sideB <= sideA)){
            System.out.println("! The Triangle does not exist!");
            return false;
        }
        return true;
    }


    @Override
    public double getPerimetr() {
        if (checkShape()) return getLine(a,b) + getLine(b,c) + getLine(a,c);
        return -1;
    }

    @Override
    public double getArea() {
        double halfP = 0.5 * getPerimetr();
        if (checkShape()) return Math.sqrt(halfP * (halfP - getLine(a,b)) * (halfP - getLine(b,c)) * (halfP - getLine(a,c)));
        return -1;
    }
}