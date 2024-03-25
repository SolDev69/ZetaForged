package zeta.zetaforged.mod.mixins.zeta;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import zeta.zetaforged.mod.managers.ConfigManager;

@Mixin(FireballEntity.class)
public class FireballFix extends AbstractFireballEntity {
    @Shadow
    private int explosionPower = 1;

    public FireballFix(EntityType<? extends AbstractFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    public FireballFix(EntityType<? extends AbstractFireballEntity> entityType, double d, double e, double f, double g, double h, double i, World world) {
        super(entityType, d, e, f, g, h, i, world);
    }

    public FireballFix(EntityType<? extends AbstractFireballEntity> entityType, LivingEntity livingEntity, double d, double e, double f, World world) {
        super(entityType, livingEntity, d, e, f, world);
    }

    /**
     * @author Zeta
     * @reason Don't know how to redirect properly
     */
    @Overwrite
    public void writeCustomDataToNbt(NbtCompound nbt) {
        if(ConfigManager.getConfig().fixFireballs.getValue()) {
            super.writeCustomDataToNbt(nbt);
            nbt.putInt("ExplosionPower", this.explosionPower);
        } else {
            super.writeCustomDataToNbt(nbt);
            nbt.putByte("ExplosionPower", (byte)this.explosionPower);
        }
    }
    /**
     * @author Zeta
     * @reason Don't know how to redirect properly
     */
    @Overwrite
    public void readCustomDataFromNbt(NbtCompound nbt) {
        if(ConfigManager.getConfig().fixFireballs.getValue()) {
            super.readCustomDataFromNbt(nbt);
            if (nbt.contains("ExplosionPower", 99)) {
                this.explosionPower = nbt.getInt("ExplosionPower");
            }
        } else {
            super.readCustomDataFromNbt(nbt);
            if (nbt.contains("ExplosionPower", 99)) {
                this.explosionPower = nbt.getByte("ExplosionPower");
            }
        }

    }
}
