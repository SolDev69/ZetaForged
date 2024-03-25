package zeta.zetaforged.mod.mixins.zeta;

import com.google.common.collect.Maps;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(SpawnEggItem.class)
public class SpawnEggFixMixin extends Item {
    @Shadow
    private static final Map<EntityType<?>, SpawnEggFixMixin> SPAWN_EGGS = Maps.newIdentityHashMap();

    @Shadow
    private final int primaryColor;
    @Shadow
    private final int secondaryColor;
    @Shadow
    private final EntityType<?> type;
    public SpawnEggFixMixin(EntityType<?> type, int primaryColor, int secondaryColor, Item.Settings settings) {
        super(settings);
        this.type = type;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        SPAWN_EGGS.put(type, this);
    }
}
