package dev.solcraft.soltweaks.mixins.worldborder.supercoder;

import dev.solcraft.soltweaks.managers.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.server.MinecraftServer;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {
	/**
	 * @author SuperCoder79
	 * @reason a
	 */
	@Overwrite
	public int getMaxWorldBorderRadius() {
		return (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Boolean.TRUE.equals(ConfigManager.getConfig().worldborderExpansion.getValue()) ? ConfigManager.getConfig().worldBorderMaxSize.getValue() : 6E7D / 2.0D));
	}
}
