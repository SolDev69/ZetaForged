package zeta.zetaforged.mod.mixins.worldborder.supercoder.beta;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.chunk.AquiferSampler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AquiferSampler.Impl.class)
public class MixinAquafierSampler {
    @Shadow @Final private int startX;

    @Shadow @Final private int startY;

    @Shadow @Final private int startZ;

    @Shadow @Final private int sizeX;

    @Shadow @Final private int sizeZ;

    @Shadow @Final private AquiferSampler.Impl.FluidLevel[] waterLevels;

    /**
     * @author Zeta n supercoder
     * @reason fricc u
     */
    @Overwrite
    private int index(int x, int y, int z) {
        int i = x - this.startX;
        int j = y - this.startY;
        int k = z - this.startZ;
        int dx = (j * this.sizeZ + k) * this.sizeX + i;
        return MathHelper.clamp(dx, 0, this.waterLevels.length - 1);
    }
}