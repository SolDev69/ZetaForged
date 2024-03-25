package zeta.zetaforged.api.util.trinaryconverter;

import zeta.zetaforged.api.util.baseconverter.BaseInteger;

public class Trinary extends BaseInteger {
    protected int[] i;
    public Trinary(int db) {
        super(db, 3);
    }
    @Override
    public void print() {
        int x = i.length - 1;
        while (x >= 0) {
            System.out.print(i[x]);
            x--;
        }
    }
}