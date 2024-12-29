package dev.solcraft.soltweaks.managers.portals;

import dev.solcraft.soltweaks.features.items.SolTweaksItems;
import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import dev.solcraft.soltweaks.SolTweaks;
import dev.solcraft.soltweaks.features.items.RegisterVoidItems;
import dev.solcraft.soltweaks.features.items.keystone.KeystoneRegistry;

public class PortalManager implements ModInitializer {
    @Override
    public void onInitialize() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.MOSS_BLOCK)
                .destDimID(new Identifier(SolTweaks.MOD_ID, "lush_nether"))
                .tintColor(0,64,8)
                .lightWithWater()
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(SolTweaksItems.KEYSTONE_BLOCK)
                .destDimID(new Identifier(SolTweaks.MOD_ID, "etheral"))
                .tintColor(127, 127, 0)
                .lightWithItem(SolTweaksItems.KEYSTONE)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(SolTweaks.GIGACONCERN_BLOCK)
                .destDimID(new Identifier(SolTweaks.MOD_ID, "concerningworld"))
                .tintColor(32, 105, 168)
                .lightWithItem(Items.FLINT_AND_STEEL)
                .registerPortal();

        CustomPortalBuilder.beginPortal()
                .frameBlock(SolTweaksItems.VoidBlock_BLOCK)
                .destDimID(new Identifier(SolTweaks.MOD_ID, "void_dimension"))
                .tintColor(0, 0, 0)
                .lightWithWater()
                .registerPortal();


    }
    public Identifier ZMI(String name) {
        return new Identifier(SolTweaks.MOD_ID, name);
    }
}
