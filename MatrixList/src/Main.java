import java.util.List;

/**
 * Created by Сергей on 24.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        MatrixList List = new MatrixList();
        int[] b = {5, 2, 1, -3};
        Matrix2x2 B = new Matrix2x2(b);
        List.addHead(B);
        int[] a = {-1, 0, 1, 0};
        Matrix2x2 A = new Matrix2x2(a);
        List.addHead(A);
        int[] c = {7, 3, 4, 5};
        Matrix2x2 C = new Matrix2x2(c);
        List.addTail(C);
        int[] d = {3, 6, 2, 4};
        Matrix2x2 D = new Matrix2x2(d);
        List.addTail(D);
        List.remove(B);
        List.forEach(Matrix2x2 -> Matrix2x2.print());
        List.forEach(Matrix2x2 -> Matrix2x2.transpose());
        detSort(List);
        List.forEach(Matrix2x2 -> Matrix2x2.print());
    }
    public static void detSort (MatrixList L) {
        int i = 0;
        while (L.get(i) != null) {
            Matrix2x2 max = L.get(i);
            for (Matrix2x2 pointer2 = L.get(i).getNext(); pointer2 != null ; pointer2 = pointer2.getNext()) {
                if (max.det() < pointer2.det()) {
                    max = pointer2;
                }
            }
            for (Matrix2x2 pointer3 = L.get(i); pointer3 != null ; pointer3 = pointer3.getNext()) {
                if (max.det() == pointer3.det()) {
                    L.remove(pointer3);
                    L.addHead(pointer3);
                    pointer3 = L.get(i);
                    i++;
                }
            }
        }
    }
}
