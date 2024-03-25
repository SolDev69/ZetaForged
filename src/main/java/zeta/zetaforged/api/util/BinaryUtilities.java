package zeta.zetaforged.api.util;

import net.minecraft.util.math.MathHelper;

public class BinaryUtilities {
    public static int encode(int i) {
        return (10*Math.floorDiv(i, (int) Math.pow(10, Math.floor(i % (Math.log10(i))))))+i%10;
    }
    public class PowersOfTwo {
        int[] powerOfTwoArray = new int[31];
        int indexedpoweroftwo;
        public PowersOfTwo() {
            int i = 1;
            for(int index = 0; i < 31; i++) {
                powerOfTwoArray[index] = i;
                i *= 2;
            }
        }
        public PowersOfTwo(int index) {
            indexedpoweroftwo = powerOfTwoArray[index];

        }
        public int[] callPowerOfTwoArray() {
            return powerOfTwoArray;
        }
    }
}
