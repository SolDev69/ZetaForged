package zeta.zetaforged.api.util.baseconverter;

public class BaseInteger extends ArrayUtilities {
    protected int[] i;
    protected int base;
    protected final int input;
    public BaseInteger(int db, int bs) {
        base = bs;
        input = db;
        i = new int[(int) (Math.log10(db)/Math.log10(bs)) + 1];
        int floored = (int)Math.floor(db/(double)bs);
        i[0] = db%bs;
        int dex = 1;
        while(dex <=
                (int)(log_base(db,bs))) {
            i[dex] = floored % bs;
            floored = (int)Math.floor(floored/(double)bs);
            dex++;
        }



    }
    /**
     * @param i = input integer
     * @param b = base
     * @return log in base b
     */
    public static double log_base(int i, int b) {
        return Math.log10(i)/Math.log10(b);
    }
    @Override
    public void print() {
        int x = i.length - 1;
        while (x >= 0) {
            if (base <= 10) {
                System.out.print(i[x]);
            } else {
                System.out.print("["+i[x]+"] ");
            }
            x--;
        }
    }

}