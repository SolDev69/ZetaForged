package dev.solcraft.soltweaks.features.items;

import dev.solcraft.soltweaks.SolTweaks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;

public class CrashItemInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(SolTweaks.MOD_ID,
                "crashitem"
        ), new CrashItem(new FabricItemSettings().group(SolTweaks.SOLTWEAKS_ITEMS)));
        SolTweaks.log(Level.INFO,"Intialized debug item!");
    }
}