package dev.solcraft.soltweaks.mixins;

import dev.solcraft.soltweaks.managers.GeneralManager;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = OctavePerlinNoiseSampler.class, priority = Integer.MAX_VALUE)
public class FarLandsMixins {
	/**
	 * @author ZetaTheEliatrope
	 * @reason Adds back the farlands.
	 */
	@Overwrite
	public static double maintainPrecision(double d) {

		return GeneralManager.FarLandsManager.
				maintainPrecisionManageable(d);
	}
}
