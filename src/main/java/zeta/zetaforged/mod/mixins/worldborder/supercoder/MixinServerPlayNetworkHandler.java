package zeta.zetaforged.mod.mixins.worldborder.supercoder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.network.ServerPlayNetworkHandler;

@Mixin(ServerPlayNetworkHandler.class)
public class MixinServerPlayNetworkHandler {
    /**
     * @author SuperCoder79
     * @reason more jd ah
     */
    @Overwrite
    private static boolean isMovementInvalid(double d, double e, double f, float g, float h) {
        return false;
    }

    @Inject(method = "clampHorizontal", at = @At("RETURN"), cancellable = true)
    private static void clampHorizontal(double d, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(d);
    }

    @Inject(method = "clampVertical", at = @At("RETURN"), cancellable = true)
    private static void clampVertical(double d, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(d);
    }
}
