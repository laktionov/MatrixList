import org.jetbrains.annotations.Contract;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Сергей on 24.09.2017.
 */
public class MatrixList implements Iterable<Matrix2x2> {
    private Matrix2x2 head;
    private Matrix2x2 tail;
    MatrixList() {
        head = null;
        tail = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addHead(Matrix2x2 M) {
        if (isEmpty() == true) {
            head = M;
            tail = M;
        } else {
            M.setNext(head);
            head = M;
        }
    }

    public void addTail(Matrix2x2 M) {
        if (isEmpty() == true) {
            head = M;
            tail = M;
        } else {
            tail.setNext(M);
            tail = M;
        }
    }

    public Matrix2x2 get(int index) {
        Matrix2x2 pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }
        return pointer;
    }

    public void remove(Matrix2x2 M) {
        while (head == M) {
            head = head.getNext();
        }
        Matrix2x2 pointer = head;
         while (pointer.getNext() != null) {
            if (pointer.getNext() == M) {
                pointer.setNext((pointer.getNext()).getNext());
            } else {
                pointer = pointer.getNext();
            }
        }
    }

    @Override
    public Iterator<Matrix2x2> iterator() {
        Iterator<Matrix2x2> it = new Iterator<Matrix2x2>() {
            Matrix2x2 pointer = head;
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Matrix2x2 next() {
                if (pointer == null) {
                    throw new NoSuchElementException();
                }
                Matrix2x2 temp = pointer;
                pointer = pointer.getNext();
                return temp;
            }
        };
        return it;
    }
}
