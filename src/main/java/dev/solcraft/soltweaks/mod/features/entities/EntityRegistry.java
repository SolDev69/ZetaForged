package dev.solcraft.soltweaks.mod.features.entities;

import net.fabricmc.api.ModInitializer;

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
