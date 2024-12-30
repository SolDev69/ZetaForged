package dev.solcraft.soltweaks.mixins.accessors;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.WorldBorderCommand;
import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WorldBorderCommand.class)
public interface WorldBorderCommandAccessor {

    @Invoker("executeGet")
    static int executeGet(ServerCommandSource source) {
        throw new AssertionError();
    }

    @Invoker("executeSet")
    static int executeSet(ServerCommandSource source, double distance, long time) throws CommandSyntaxException {
        throw new AssertionError();
    }

    @Invoker("executeCenter")
    static int executeCenter(ServerCommandSource source, Vec2f pos) {
        throw new AssertionError();
    }

    @Invoker("executeWarningDistance")
    static int executeWarningDistance(ServerCommandSource source, int i)
    {
        throw new AssertionError();
    }

    @Invoker("executeBuffer")
    static int executeBuffer(ServerCommandSource source, float f) {
        throw new AssertionError();
    }

    @Invoker("executeDamage")
    static int executeDamage(ServerCommandSource source, float f) {
        throw new AssertionError();
    }

    @Invoker("executeWarningTime")
    static int executeWarningTime(ServerCommandSource source, int i) {
        throw new AssertionError();
    }

}