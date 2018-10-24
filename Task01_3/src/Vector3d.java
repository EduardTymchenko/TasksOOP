/*
������� ����� �Vector3d� (�.�. �� ������ ��������� ������ � 3-�
������, ���������� ������� ���������). � �������� ������� �����
������ �������� ���������� �������. ��� ����� ������ �����������
������ ��������, � ���������� � ���������� ������������ ��������.
�������� ��������� �������� ����� ������ � ������������� ��.
 */
public class Vector3d {
    private double vectorX;
    private double vectorY;
    private double vectorZ;

    public Vector3d(double beginPointX, double beginPointY, double beginPointZ, double endPointX, double endPointY, double endPointZ) {
        this.vectorX = endPointX - beginPointX;
        this.vectorY = endPointY - beginPointY;
        this.vectorZ = endPointZ - beginPointZ;
    }

    public Vector3d(double vectorX, double vectorY, double vectorZ) {
        this.vectorX = vectorX;
        this.vectorY = vectorY;
        this.vectorZ = vectorZ;
    }
    public static Vector3d sumVectors(Vector3d a, Vector3d b){
        return new Vector3d (a.vectorX + b.vectorX, a.vectorY + b.vectorY, a.vectorZ + b.vectorZ);
    }
    public static double scalarMultiplication(Vector3d a, Vector3d b){
        return a.vectorX * b.vectorX + a.vectorY * b.vectorY + a.vectorZ * b.vectorZ;
    }
    public static Vector3d vectorMultiplication(Vector3d a, Vector3d b){
        return new Vector3d (a.vectorY * b.vectorZ - a.vectorZ * b.vectorY,
                a.vectorZ * b.vectorX - a.vectorX * b.vectorZ,
                a.vectorX * b.vectorY - a.vectorY * b.vectorX);
    }
    public String toString(){
        return "Vector(" + vectorX + ", " + vectorY + ", " + vectorZ + ")";
    }
}
