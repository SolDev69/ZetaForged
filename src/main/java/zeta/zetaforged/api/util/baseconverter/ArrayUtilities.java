package zeta.zetaforged.api.util.baseconverter;

public abstract class ArrayUtilities {
    public void printArray(int [] i) {
        int x = i.length - 1;
        while (x >= 0) {
            System.out.print(i[x]);
            x--;
        }
    }
    public abstract void print();
}
