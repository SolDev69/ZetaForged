package dev.solcraft.soltweaks.managers;

public class NoiseScaleManager {
    public static double coordinateScale() {
        return GeneralManager.getConfig().coordinateScale.getValue();
    }
    public static double heightScale() {
        return GeneralManager.getConfig().heightScale.getValue();
    }
}
