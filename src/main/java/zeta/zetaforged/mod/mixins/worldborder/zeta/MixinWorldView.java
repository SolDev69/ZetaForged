package zeta.zetaforged.mod.mixins.worldborder.zeta;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldView.class)
public interface MixinWorldView extends BlockRenderView {
    /**
     * @author
     */
    @Overwrite
    default int getLightLevel(BlockPos pos, int ambientDarkness) {
        return pos.getX() >= Integer.MIN_VALUE && pos.getZ() >= Integer.MIN_VALUE && pos.getX() < Integer.MAX_VALUE && pos.getZ() < Integer.MAX_VALUE ? this.getBaseLightLevel(pos, ambientDarkness) : 15;
    }
}
