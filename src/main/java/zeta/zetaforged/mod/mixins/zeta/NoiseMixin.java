package zeta.zetaforged.mod.mixins.zeta;

import net.minecraft.world.gen.NoiseColumnSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import zeta.zetaforged.mod.managers.GeneralManager;

@Mixin(NoiseColumnSampler.class)
public class NoiseMixin {
    private static final double cs = 684.412d;
    @ModifyConstant(
            constant = @Constant(
                    doubleValue = cs,
                    ordinal = 0
            ),
            method = "sampleNoiseColumn"
    )
    private static double setCoordinateScale(double original) {
        return GeneralManager.getConfig().coordinateScale.getValue() *
                GeneralManager.getConfig().coordinateScaleMultiplier.getValue();
    }
    @ModifyConstant(
            constant = @Constant(
                    doubleValue = cs,
                    ordinal = 1
            ),
            method = "sampleNoiseColumn"
    )
    private static double setHeightScale(double original) {
        return GeneralManager.getConfig().coordinateScale.getValue()
                * GeneralManager.getConfig().heightScaleMultiplier.getValue();
    }

}
