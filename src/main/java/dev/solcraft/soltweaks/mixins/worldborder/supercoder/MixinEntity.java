package dev.solcraft.soltweaks.mixins.worldborder.supercoder;

import dev.solcraft.soltweaks.managers.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

@Mixin(Entity.class)
public class MixinEntity {
	@Redirect(method = "updatePosition", at = @At(target = "Lnet/minecraft/util/math/MathHelper;clamp(DDD)D", value = "INVOKE"))
	private double redirectClamp(double value, double min, double max) {
		return MathHelper.clamp(value, -((int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D))), (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D)));
	}
}
