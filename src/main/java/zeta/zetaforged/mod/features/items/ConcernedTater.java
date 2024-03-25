package zeta.zetaforged.mod.features.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ConcernedTater extends Item {
    public ConcernedTater(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = playerEntity.getStackInHand(hand);
        playerEntity.setHealth(100.0F);
        playerEntity.setMovementSpeed(100F);
        for(int integer = 0; integer < 5; integer++) {
            playerEntity.teleport(12550800, 100, 0);
        }
        long sleepTime = Short.MAX_VALUE;
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            try {
                sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        playerEntity.teleport(0, 100, 0);
        itemStack.decrement(1);
        return TypedActionResult.success(itemStack, world.isClient());
        // Fixed concernedtaters in survival
    }

    protected void sleep(long value) throws InterruptedException {
        Thread.sleep(value);
    }

}
