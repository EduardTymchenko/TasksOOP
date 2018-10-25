/*
Создайте абстрактный класс Shape в котором есть два
абстрактных метода double getPerimetr() и double getArea().
 */
public abstract class Shape {
    public abstract double getPerimetr();
    public abstract double getArea();

    protected double getLine(Point start, Point end){
        return Math.sqrt(Math.pow((end.getX() - start.getX()),2) +
                Math.pow((end.getY() - start.getY()),2));
    }

    public abstract boolean checkShape();
}
