package zeta.zetaforged.mod.mixins.zeta;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.InterpolatedNoiseSampler;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import net.minecraft.util.math.noise.PerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import zeta.zetaforged.mod.managers.GeneralManager;

@Mixin(InterpolatedNoiseSampler.class)
public class IndividualNoiseMixin {
//    @ModifyArg(
//            method = "Lnet/minecraft/util/math/noise/InterpolatedNoiseSampler;sample(IIIDDDD)D",
//            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/util/math/noise/OctavePerlinNoiseSampler;maintainPrecision(D)D"),
//            index = 2
//    )
//    private double mixin(double d) {
//
//    }

    @Shadow
    private final OctavePerlinNoiseSampler interpolationNoise;
    @Shadow
    private final OctavePerlinNoiseSampler lowerInterpolatedNoise;
    @Shadow
    private final OctavePerlinNoiseSampler upperInterpolatedNoise;

    public IndividualNoiseMixin(OctavePerlinNoiseSampler interpolationNoise, OctavePerlinNoiseSampler lowerInterpolatedNoise, OctavePerlinNoiseSampler upperInterpolatedNoise) {
        this.interpolationNoise = interpolationNoise;
        this.lowerInterpolatedNoise = lowerInterpolatedNoise;
        this.upperInterpolatedNoise = upperInterpolatedNoise;
    }

    /**
 * @author
 * @reason Probably wont work without one
 */
@Overwrite
    public double sample(int i, int j, int k, double horizontalScale, double verticalScale, double horizontalStretch, double verticalStretch) {
        double d = 0.0;
        double e = 0.0;
        double f = 0.0;
        boolean bl = true;
        double g = 1.0;
        for (int l = 0; l < 8; ++l) {
            PerlinNoiseSampler perlinNoiseSampler = this.interpolationNoise.getOctave(l);
            if (perlinNoiseSampler != null) {
                f += perlinNoiseSampler.sample(OctavePerlinNoiseSampler.maintainPrecision((double)i * horizontalStretch * g), OctavePerlinNoiseSampler.maintainPrecision((double)j * verticalStretch * g), OctavePerlinNoiseSampler.maintainPrecision((double)k * horizontalStretch * g), verticalStretch * g, (double)j * verticalStretch * g) / g;
            }
            g /= 2.0;
        }
        double l = (f / 10.0 + 1.0) / 2.0;
        boolean bl2 = l >= 1.0;
        boolean bl3 = l <= 0.0;
        g = 1.0;
        for (int m = 0; m < 16; ++m) {
            PerlinNoiseSampler perlinNoiseSampler2;
            double h = OctavePerlinNoiseSampler.maintainPrecision((double)i *
                    GeneralManager.getConfig().individualCoordinateScaleMultiplierX.getValue() *
                    horizontalScale * g);
            double n = OctavePerlinNoiseSampler.maintainPrecision((double)j * verticalScale * g);
            double o = OctavePerlinNoiseSampler.maintainPrecision((double)k *
                    GeneralManager.getConfig().individualCoordinateScaleMultiplierZ.getValue() *
                    horizontalScale * g);
            double p = verticalScale * g;
            if (!bl2 && (perlinNoiseSampler2 = this.lowerInterpolatedNoise.getOctave(m)) != null) {
                d += perlinNoiseSampler2.sample(h, n, o, p, (double)j * p) / g;
            }
            if (!bl3 && (perlinNoiseSampler2 = this.upperInterpolatedNoise.getOctave(m)) != null) {
                e += perlinNoiseSampler2.sample(h, n, o, p, (double)j * p) / g;
            }
            g /= 2.0;
        }
        return MathHelper.clampedLerp(d / 512.0, e / 512.0, l);
    }
}
