package zeta.zetaforged.mod.mixins.worldborder.supercoder;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.border.WorldBorder;

@Mixin(WorldBorder.Properties.class)
public class MixinWorldBorderProperties {
	@Mutable
	@Shadow @Final private double size;

	@Inject(method = "<init>(DDDDIIDJD)V", at = @At("RETURN"))
	private void handleConstructor(double centerX, double centerZ, double damagePerBlock, double buffer, int warningBlocks, int warningTime, double size, long targetRemainingTime, double targetSize, CallbackInfo ci) {
		this.size = 4294967294D;
	}

	/**
	 * @author Zeta
	 * @reason Fix wb
	 */
}
