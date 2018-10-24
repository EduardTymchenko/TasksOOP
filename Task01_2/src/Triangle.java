/*
Описать класс «Triangle». В качестве свойств возьмите длинны
сторон треугольника. Реализуйте метод который будет возвращать
площадь этого треугольника. Создайте несколько объектов этого
класса и протестируйте их.
 */
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if((a + b <= c) || (a + c <= b) || (c + b <= a) || a < 0 || b < 0 || c < 0){
            return;
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public double area (){
        if (a == 0 || b == 0 || c == 0) {
            System.out.println("There is no such triangle!");
            return -1;
        } else {
            double p;
            p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }
}
