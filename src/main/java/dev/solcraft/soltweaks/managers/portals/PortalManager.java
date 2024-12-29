package dev.solcraft.soltweaks.managers.portals;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import dev.solcraft.soltweaks.SolTweaks;
import dev.solcraft.soltweaks.features.items.RegisterVoidItems;
import dev.solcraft.soltweaks.features.keystone.Keystone;

public class PortalManager implements ModInitializer {
    @Override
    public void onInitialize() {
        CustomPortalApiRegistry.addPortal(Blocks.MOSS_BLOCK,
                new Identifier(SolTweaks.MOD_ID, "lush_nether"),
                0, 64, 8);
        CustomPortalApiRegistry.addPortal(Keystone.KEYSTONE_BLOCK,
                new Identifier(SolTweaks.MOD_ID, "etheral"),
                127, 127, 0);
        CustomPortalApiRegistry.addPortal(SolTweaks.GIGACONCERN_BLOCK,
                new Identifier(SolTweaks.MOD_ID, "concerningworld"),
                32, 105, 168
        );
        CustomPortalApiRegistry.addPortal(RegisterVoidItems.VoidBlock_BLOCK,
                new Identifier(SolTweaks.MOD_ID, "void_dimension"),
                0,0,0
        );

    }
    public Identifier ZMI(String name) {
        return new Identifier(SolTweaks.MOD_ID, name);
    }
}
