package zeta.zetaforged.mod.mixins.zeta.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.Random;

import static zeta.zetaforged.mod.ZetaForged.*;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import zeta.zetaforged.mod.managers.ConfigManager;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public class MixinTitleScreen extends Screen {

    @Shadow private final boolean doBackgroundFade;
    @Shadow private long backgroundFadeStart;
    @Shadow private final boolean isMinceraft;
    protected MixinTitleScreen(Text title, boolean doBackgroundFade, boolean isMinceraft) {
        super(title);
        this.doBackgroundFade = doBackgroundFade;
        this.isMinceraft = isMinceraft;
    }
    @ModifyConstant(
            constant = @Constant(
                    doubleValue = 1.0e-4d,
                    ordinal = 0
            ),
            method = "<init>(Z)V"
    )
    private double handleMinceraft(double original) {
        return 1.0d;
    }
    @Inject(at = @At("TAIL"), method = "render")
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        float f = this.doBackgroundFade ? (float)(Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0f : 1.0f;
        float g = this.doBackgroundFade ? MathHelper.clamp(f - 1.0f, 0.0f, 1.0f) : 1.0f;
        int l = MathHelper.ceil(g * 255.0f) << 24;
        if((Date.from(Instant.now()).getDate() == 16 && Date.from(Instant.now()).getMonth() == Calendar.MARCH)
                // For testing purposes
                //|| Boolean.TRUE.equals(ConfigManager.getConfig().isDevVersion.getValue())
        )
            drawStringWithShadow(matrices, this.textRenderer, "HAPPY BIRTHDAY ZETAFORGED!", 2, 2, 0xffff00 | l);
        /* TODO: move this to the API later */ drawStringWithShadow(matrices, this.textRenderer, "Mods Loaded: " + (FabricLoader.getInstance().getAllMods().toArray().length-54), 2, this.height - 30, 16777215|l);
        if(System.getProperty("java.version").startsWith("16") || System.getProperty("java.version").startsWith("17")) {
            drawStringWithShadow(matrices, this.textRenderer, "Running on java version " + System.getProperty("java.version"), 2, this.height - 40, 16777215|l);
        } else {
            drawStringWithShadow(matrices, this.textRenderer, "Running on java version " + System.getProperty("java.version"), 2, this.height - 50, 16777215|l);
            drawStringWithShadow(matrices, this.textRenderer, "WARNING! It is recommended you play on java 16 or 17 for maximum stability", 2, this.height - 40, 16777215|l);

            //drawStringWithShadow(matrices, this.textRenderer, "Bugs specific to java 18 and 19 won't be fixed. You have been warned!", 2, this.height - 40, 16777215|l);

        }
        if(isDevVersion()) {
            drawStringWithShadow(matrices, this.textRenderer, ZFVersionString + "/dev", 2, this.height - 20, 16777215 | l);
        } else {
            drawStringWithShadow(matrices, this.textRenderer, ZFVersionString , 2, this.height - 20, 16777215 | l);
        }
    }
}
