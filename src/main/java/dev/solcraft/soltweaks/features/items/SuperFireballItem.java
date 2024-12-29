package dev.solcraft.soltweaks.features.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import dev.solcraft.soltweaks.managers.ConfigManager;

import java.util.Objects;

public class SuperFireballItem extends Item {
    public SuperFireballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity thePlayer, Hand hand) {
        ItemStack stack = thePlayer.getStackInHand(hand);
        BlockPos blockPos = thePlayer.getBlockPos();
        NbtCompound nbt = new NbtCompound();
        Identifier entityToSpawn = new Identifier("minecraft", "fireball");
        boolean initialize = true;
        if (!World.isValid(blockPos)) {
            return TypedActionResult.fail(stack);
        } else {
            NbtCompound nbtCompound = nbt.copy();
            nbtCompound.putString("id", entityToSpawn.toString());
            nbtCompound.putInt("ExplosionPower", Objects.requireNonNull(ConfigManager.getConfig().superFireballStrength.getValue()));
            ServerCommandSource source = thePlayer.getCommandSource();
            ServerWorld serverWorld = source.getWorld();
            Entity entityObject = EntityType.loadEntityWithPassengers(nbtCompound, serverWorld, entity -> {
                entity.refreshPositionAndAngles(thePlayer.getPos().x, thePlayer.getPos().y, thePlayer.getPos().z, entity.getYaw(), entity.getPitch());
                return entity;
            });

            if (entityObject == null) {
                return TypedActionResult.fail(stack);
            } else {
                if (initialize && entityObject instanceof MobEntity) {
                    ((MobEntity)entityObject).initialize(source.getWorld(), source.getWorld().getLocalDifficulty(entityObject.getBlockPos()), SpawnReason.COMMAND, null, null);
                }

                if (!((ServerWorld)world).shouldCreateNewEntityWithPassenger(entityObject)) {
                    return TypedActionResult.fail(stack);
                } else {
                    //source.sendFeedback(new TranslatableText("commands.summon.success", new Object[]{entity2.getDisplayName()}), true);
                    return TypedActionResult.consume(stack);
                }
            }
        }

    }
}
