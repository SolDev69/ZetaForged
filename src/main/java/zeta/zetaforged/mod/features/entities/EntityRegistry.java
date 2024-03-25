package zeta.zetaforged.mod.features.entities;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static zeta.zetaforged.mod.ZetaForged.MOD_ID;

public class EntityRegistry implements ModInitializer {
//    public static final EntityType<Entity> superFireball = Registry.register(
//            Registry.ENTITY_TYPE,
//            new Identifier(MOD_ID, "superidolball"),
//            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ).dimensions(EntityDimensions.fixed(1,1)).build()
//    );
    public static boolean registerEntities() {
        return true;
    }

    @Override
    public void onInitialize() {
        registerEntities();
    }
}
