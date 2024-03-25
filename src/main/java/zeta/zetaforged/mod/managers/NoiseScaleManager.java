package zeta.zetaforged.mod.managers;

public class NoiseScaleManager {
    public static double coordinateScale() {
        return GeneralManager.getConfig().coordinateScale.getValue();
    }
    public static double heightScale() {
        return GeneralManager.getConfig().heightScale.getValue();
    }
}
