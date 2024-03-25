package zeta.zetaforged.api;

public final class MathHelper {
    public static long farlandsCalc(int input) {
        return floorDiv(input, 171.103d);
    }
    public static long farlandsCalc(int input, int scale) {
        return floorDiv(input * scale, 171.103d);
    }

    public static long floorDiv(double in1, double in2) {
        return (long) Math.floor(in1 / in2);
    }
}
