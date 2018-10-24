public class MainVector3d {
    public static void main(String[] args) {
        Vector3d vector3d = new Vector3d(2,-1,3,5,3,1);
        System.out.println("Vector of points: " + vector3d.toString());
        Vector3d vector3d1 = new Vector3d(1,2,3);
        System.out.println("Vector1: " + vector3d1.toString());
        Vector3d vector3d2 = new Vector3d(2,1,-2);
        System.out.println("Vector2: " + vector3d2.toString());
        System.out.println("Sum of vectors: " + Vector3d.sumVectors(vector3d1,vector3d2).toString());
        System.out.println("Scalar multiplication of vectors: " + Vector3d.scalarMultiplication(vector3d1,vector3d2));
        System.out.println("Vector multiplication of vectors: " + Vector3d.vectorMultiplication(vector3d1,vector3d2));
    }
}
