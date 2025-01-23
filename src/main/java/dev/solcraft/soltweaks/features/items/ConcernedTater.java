package dev.solcraft.soltweaks.features.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;
import java.util.random.RandomGenerator;

public class ConcernedTater extends Item {
    public ConcernedTater(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        playerEntity.setHealth(100.0F);
        playerEntity.setMovementSpeed(100F);
        Random r = new Random();
        double x = r.nextDouble(r.nextInt(0, 10001) == 10000 ? -Double.MAX_VALUE : -3E7D,r.nextInt(0, 10001) == 10000 ? Double.MAX_VALUE : 3E7D);
        double y = r.nextDouble(r.nextBoolean() ? -Double.MAX_VALUE : -3E7D,r.nextBoolean() ? Double.MAX_VALUE : 3E7D);
        double z = r.nextDouble(r.nextInt(0, 10001) == 10000 ? -Double.MAX_VALUE : -3E7D,r.nextInt(0, 10001) == 10000 ? Double.MAX_VALUE : 3E7D);
        System.out.printf("You rolled a: %f, %f, %f\n", x, y, z);
        playerEntity.teleport(x, y, z);
//        long sleepTime = Short.MAX_VALUE;
//        try {
//            sleep(sleepTime);
//        } catch (InterruptedException e) {
//            try {
//                sleep(sleepTime);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
        itemStack.decrement(1);
        return TypedActionResult.success(itemStack, world.isClient());
        // Fixed concernedtaters in survival
    }

    protected void sleep(long value) throws InterruptedException {
        Thread.sleep(value);
    }

}
