package dev.solcraft.soltweaks.mixins.worldborder.zeta;

import dev.solcraft.soltweaks.managers.ConfigManager;
import net.minecraft.util.collection.LinkedBlockPosHashSet;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LinkedBlockPosHashSet.Storage.class)
public class MixinLinkedBlockPosHashSetStorage {
    @Shadow
    private static int STARTING_OFFSET;
    @Shadow
    private static int HORIZONTAL_COLUMN_BIT_SEPARATION;
    //TODO: If something breaks this is where
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void handleConstructor(CallbackInfo ci) {
        STARTING_OFFSET = MathHelper.log2(((int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D))));
        HORIZONTAL_COLUMN_BIT_SEPARATION = MathHelper.log2(((int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D))));
    }
}
