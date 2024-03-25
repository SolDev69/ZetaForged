package zeta.zetaforged.mod.mixins.zeta.shard;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.noise.PerlinNoiseSampler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import zeta.zetaforged.mod.managers.GeneralManager;

@Mixin(value = PerlinNoiseSampler.class, priority = 999)
public abstract class Shard {
    private boolean logged = false;

    @Shadow
    @Final
    public double originX;
    @Shadow
    @Final
    public double originY;
    @Shadow
    @Final
    public double originZ;

    @Inject(method = "sample(DDDDD)D", at = @At("RETURN"), cancellable = true)
    public void sample(double x, double y, double z, double yScale, double yMax, CallbackInfoReturnable<Double> cir) {
        double d = x + originX;
        double e = y + originY;
        double f = z + originZ;
        int i = MathHelper.floor(d);
        int j = MathHelper.floor(e);
        int k = MathHelper.floor(f);
        double g, h, l;
        if (GeneralManager.getConfig().shardFarLands.getValue()) {
            g = d - (float) i;
            h = e - (float) j;
            l = f - (float) k;
        } else {
            g = d - (double) i;
            h = e - (double) j;
            l = f - (double) k;
        }
        double p;
        if (yScale != 0.0D) {
            double n;
            if (yMax >= 0.0D && yMax < h) {
                n = yMax;
            } else {
                n = h;
            }
            p = (double) MathHelper.floor(n / yScale + 1.0000000116860974E-7D) * yScale;
        } else {
            p = 0.0D;
        }
        cir.setReturnValue(sample(i, j, k, g, h - p, l, h));
    }

    @Inject(method = "sampleDerivative(DDD[D)D", at = @At("RETURN"), cancellable = true)
    public void sampleDerivative(double x, double y, double z, double[] ds, CallbackInfoReturnable<Double> cir) {
        double d = x + originX;
        double e = y + originY;
        double f = z + originZ;
        int i = MathHelper.floor(d);
        int j = MathHelper.floor(e);
        int k = MathHelper.floor(f);
        double g, h, l;
        if (GeneralManager.getConfig().shardFarLands.getValue()) {
            g = d - (float) i;
            h = e - (float) j;
            l = f - (float) k;
        } else {
            g = d - (double) i;
            h = e - (double) j;
            l = f - (double) k;
        }
        cir.setReturnValue(sampleDerivative(i, j, k, g, h, l, ds));
    }

    @Shadow
    private double sampleDerivative(int sectionX, int sectionY, int sectionZ, double localX, double localY, double localZ, double[] ds) {
        throw new AssertionError();
    }

    @Shadow
    private double sample(int sectionX, int sectionY, int sectionZ, double localX, double localY, double localZ, double fadeLocalX) {
        throw new AssertionError();
    }
}