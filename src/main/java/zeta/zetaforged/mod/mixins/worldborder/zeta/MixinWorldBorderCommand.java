package zeta.zetaforged.mod.mixins.worldborder.zeta;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.command.argument.Vec2ArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.WorldBorderCommand;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.border.WorldBorder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

import static net.minecraft.server.command.WorldBorderCommand.*;

@Mixin(WorldBorderCommand.class)
public abstract class MixinWorldBorderCommand {
    @Shadow
    public static SimpleCommandExceptionType SET_FAILED_BIG_EXCEPTION;

    @Shadow
    @Final
    private static SimpleCommandExceptionType SET_FAILED_NO_CHANGE_EXCEPTION;
    @Shadow@Final
    private static SimpleCommandExceptionType SET_FAILED_SMALL_EXCEPTION;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void handleConstructor(CallbackInfo ci) {
        SET_FAILED_BIG_EXCEPTION = new SimpleCommandExceptionType(new TranslatableText("commands.worldborder.set.failed.big", 4294967294D));
    }
    /**
     * @author Zeta
     * @reason Fix wb
     */
    @Overwrite
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder) CommandManager.literal("worldborder").requires((source) -> {
            return source.hasPermissionLevel(2);
//TODO: Change these back and remove static import
        })).then(CommandManager.literal("add").then(((RequiredArgumentBuilder)CommandManager.argument("distance", DoubleArgumentType.doubleArg(-4294967294D, 4294967294D)).executes((context) -> {
            return executeSet((ServerCommandSource)context.getSource(), ((ServerCommandSource)context.getSource()).getWorld().getWorldBorder().getSize() + DoubleArgumentType.getDouble(context, "distance"), 0L);
        })).then(CommandManager.argument("time", IntegerArgumentType.integer(0)).executes((context) -> {
            return executeSet((ServerCommandSource)context.getSource(), ((ServerCommandSource)context.getSource()).getWorld().getWorldBorder().getSize() + DoubleArgumentType.getDouble(context, "distance"), ((ServerCommandSource)context.getSource()).getWorld().getWorldBorder().getSizeLerpTime() + (long)IntegerArgumentType.getInteger(context, "time") * 1000L);
        }))))).then(CommandManager.literal("set").then(((RequiredArgumentBuilder)CommandManager.argument("distance", DoubleArgumentType.doubleArg(-4294967294D, 4294967294D)).executes((context) -> {
            return executeSet((ServerCommandSource)context.getSource(), DoubleArgumentType.getDouble(context, "distance"), 0L);
        })).then(CommandManager.argument("time", IntegerArgumentType.integer(0)).executes((context) -> {
            return executeSet((ServerCommandSource)context.getSource(), DoubleArgumentType.getDouble(context, "distance"), (long)IntegerArgumentType.getInteger(context, "time") * 1000L);
        }))))).then(CommandManager.literal("center").then(CommandManager.argument("pos", Vec2ArgumentType.vec2()).executes((context) -> {
            return executeCenter((ServerCommandSource)context.getSource(), Vec2ArgumentType.getVec2(context, "pos"));
        })))).then(((LiteralArgumentBuilder)CommandManager.literal("damage").then(CommandManager.literal("amount").then(CommandManager.argument("damagePerBlock", FloatArgumentType.floatArg(0.0F)).executes((context) -> {
            return executeDamage((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "damagePerBlock"));
        })))).then(CommandManager.literal("buffer").then(CommandManager.argument("distance", FloatArgumentType.floatArg(0.0F)).executes((context) -> {
            return executeBuffer((ServerCommandSource)context.getSource(), FloatArgumentType.getFloat(context, "distance"));
        }))))).then(CommandManager.literal("get").executes((context) -> {
            return executeGet((ServerCommandSource)context.getSource());
        }))).then(((LiteralArgumentBuilder)CommandManager.literal("warning").then(CommandManager.literal("distance").then(CommandManager.argument("distance", IntegerArgumentType.integer(0)).executes((context) -> {
            return executeWarningDistance((ServerCommandSource)context.getSource(), IntegerArgumentType.getInteger(context, "distance"));
        })))).then(CommandManager.literal("time").then(CommandManager.argument("time", IntegerArgumentType.integer(0)).executes((context) -> {
            return executeWarningTime((ServerCommandSource)context.getSource(), IntegerArgumentType.getInteger(context, "time"));
        })))));
    }
    /**
     * @author
     * @reason
     */
    @Overwrite
    private static int executeSet(ServerCommandSource source, double distance, long time) throws CommandSyntaxException {
        WorldBorder worldBorder = source.getWorld().getWorldBorder();
        double d = worldBorder.getSize();
        if (d == distance) {
            throw SET_FAILED_NO_CHANGE_EXCEPTION.create();
        } else if (distance < 1.0D) {
            throw SET_FAILED_SMALL_EXCEPTION.create();
        } else if (distance > 4294967294D) {
            throw SET_FAILED_BIG_EXCEPTION.create();
        } else {
            if (time > 0L) {
                worldBorder.interpolateSize(d, distance, time);
                if (distance > d) {
                    source.sendFeedback(new TranslatableText("commands.worldborder.set.grow", new Object[]{String.format(Locale.ROOT, "%.1f", distance), Long.toString(time / 1000L)}), true);
                } else {
                    source.sendFeedback(new TranslatableText("commands.worldborder.set.shrink", new Object[]{String.format(Locale.ROOT, "%.1f", distance), Long.toString(time / 1000L)}), true);
                }
            } else {
                worldBorder.setSize(distance);
                source.sendFeedback(new TranslatableText("commands.worldborder.set.immediate", new Object[]{String.format(Locale.ROOT, "%.1f", distance)}), true);
            }

            return (int)(distance - d);
        }
    }
}
