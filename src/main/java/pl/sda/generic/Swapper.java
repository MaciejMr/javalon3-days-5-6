package pl.sda.generic;

public class Swapper<T> {
    T[] array;

    public void swapElements(int x, int y) {
        T i = array[x];
        array[x] = array[y];
        array[y] = i;
    }

}
