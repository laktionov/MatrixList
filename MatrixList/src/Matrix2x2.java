/**
 * Created by Сергей on 24.09.2017.
 */
public class Matrix2x2 {
    private int[] Data;
    private Matrix2x2 next;

    Matrix2x2(int[] Data) {
        this.Data = Data;
        this.next = null;
    }

    Matrix2x2 getNext() {
        return this.next;
    }

    void setNext(Matrix2x2 next) {
        this.next = next;
     }

    void print() {
        for (int i = 0; i < 4; i++) {
            System.out.print(Data[i] + " ");
            if (i == 1) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
     }

    int det() {
        return Data[0]*Data[3] - Data[1]*Data[2];
     }

    public void transpose() {
        int temp = Data[2];
        Data[2] = Data[1];
        Data[1] = temp;
     }
}
