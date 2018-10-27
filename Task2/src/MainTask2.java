public class MainTask2 {
    public static void main(String[] args) {
        Blackboard blackboard = new Blackboard();

        Shape shape1 = new Rectangle(new Point(0,0),new Point(10,10));
        if (!shape1.checkShape()) shape1 = null;
        Shape shape2 = new Circle(new Point(0,0),new Point(0,10));
        if (!shape2.checkShape()) shape2 = null;
        Shape shape3 = new Triangle(new Point(0,0),new Point(10,10),new Point(12,10));
        if (!shape3.checkShape()) shape3 = null;

        blackboard.addShape(shape1,1);
        blackboard.addShape(shape2,4);
        blackboard.addShape(shape3,2);
        System.out.println();
        System.out.println(blackboard.toString());
        System.out.println();
        blackboard.delShape(2);
        blackboard.delShape(2);
        System.out.println();
        System.out.println(blackboard.toString());
        blackboard.delAllShape();
        System.out.println();
        System.out.println(blackboard.toString());
    }
}
