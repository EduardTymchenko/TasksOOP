public class MainTriangle {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3,4,5);
        if (triangle1.area() != -1) System.out.println("Area triangle1 is " + triangle1.area());
        Triangle triangle2 = new Triangle(1,1,5);
        if (triangle2.area() != -1) System.out.println("Area triangle2 is " + triangle2.area());
        Triangle triangle3 = new Triangle(-3,-4,5);
        if (triangle3.area() != -1) System.out.println("Area triangle3 is " + triangle3.area());
        Triangle triangle4 = new Triangle(0,4,5);
        if (triangle4.area() != -1) System.out.println("Area triangle3 is " + triangle4.area());
    }
}
