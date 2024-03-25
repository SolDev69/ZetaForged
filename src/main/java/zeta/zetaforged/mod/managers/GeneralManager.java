package zeta.zetaforged.mod.managers;

import zeta.zetaforged.mod.ZetaForged;
import me.zeroeightsix.fiber.exception.FiberException;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.Level;

import java.io.IOException;

public class GeneralManager implements ModInitializer {
    public static ConfigManager CONFIG;

    static {
        try {
            CONFIG = new ConfigManager().load();
        } catch (FiberException e) {
            e.printStackTrace();
        }
    }
    public static ConfigManager getConfig() {
        return CONFIG;
    }

    public static void saveConfig() {
        CONFIG.save();
    }


    @Override
    public void onInitialize() {}

    public static class FarLandsManager {
        // This is now mixinable!
        public static boolean farlands() {
            return
                    getConfig().farLandsEnabled.getValue();
        }
        public static Boolean FARLANDS_INTIALIZED = false;
        public static final double maintainPrecisionManageable(double d) {
            if(farlands()) {
                if (!FARLANDS_INTIALIZED) {
                    FARLANDS_INTIALIZED = !FARLANDS_INTIALIZED;
                    ZetaForged.log(Level.INFO, "FarLands intialized!");
                }
                return d;
            }
            else {
                return d - (double) MathHelper.lfloor(d / 3.3554432E7D + 0.5D) * 3.3554432E7D;
            }
        }
    }

}
