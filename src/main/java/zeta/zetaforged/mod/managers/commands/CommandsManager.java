package zeta.zetaforged.mod.managers.commands;


import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import net.minecraft.text.LiteralText;
import zeta.zetaforged.mod.managers.GeneralManager;
//Static imports
// getString(ctx, "string")
// word()
// literal("foo")
import static net.minecraft.server.command.CommandManager.literal;
// argument("bar", word())
// Import everything
import static zeta.zetaforged.mod.ZetaForged.ZFVersionString;
import static zeta.zetaforged.mod.managers.GeneralManager.getConfig;

@SuppressWarnings("ALL")
public class CommandsManager {
//    public static String version1 =
//            "ZetaForged version " + ZetaForged.MOD_VERSION +
//                    SPACE + "build" + SPACE + MOD_DEV_V + SPACE + ZetaForged.PHASE +
//                    "\n" +
//                    //"Technical Blocks version " + TechnicalBlocks.tb_version + "\n" +
//                    "Running on Minecraft " +
//                    SharedConstants.getGameVersion().getName() +
//                    "\nUsing Java version "+System.getProperty("java.version");
//    public static String version2 =
//            "ZetaForged version " + ZetaForged.MOD_VERSION +
//                    SPACE + "build" + SPACE + MOD_DEV_V + SPACE + ZetaForged.PHASE +
//                    "\n" +
//                    //"Technical Blocks version " + TechnicalBlocks.tb_version + "\n" +
//                    "Running on Minecraft " +
//                    SharedConstants.getGameVersion().getName() +
//                    "\nUsing Java version "+System.getProperty("java.version");

    public void initCommands() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
            //PlaceFeatureCommand.register(dispatcher);
        }));
//        CommandRegistrationCallback.EVENT.register(((dispatcher, dedicated) -> {
//            PlaceStructureCommand.register(dispatcher);
//        }));
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            /**
             * /zetaforged
             */
            dispatcher.register(literal("zetaforged").then(literal("version").executes(
                    context -> {
                        context.getSource().sendFeedback(new LiteralText(
                                "[ZetaForged] " + ZFVersionString
                        ),true);
//                        context.getSource().sendFeedback(new LiteralText(
//                                "[Zeta's API] ZetaForged API 1.0.0-alpha.2"
//                        ),true);
                        context.getSource().sendFeedback(new LiteralText(
                                "[Minecraft] Running on version " + SharedConstants.getGameVersion().getName()), true
                        );
                        context.getSource().sendFeedback(new LiteralText(
                                "[Java] Using Java version " + System.getProperty("java.version")), true
                        );
                        context.getSource().sendFeedback(new LiteralText(
                                "[Fabric] Loaded on Fabric version " + FabricLoader.getInstance().getModContainer("fabricloader").get().getMetadata().getVersion() + " with api " + FabricLoader.getInstance().getModContainer("fabric").get().getMetadata().getVersion()), true
                        );
                        return 1;
                    }
            ).then(literal("debug").executes(context -> {
                context.getSource().sendError(new LiteralText("this feature was removed, please just use the normal /zetaforged version command"));
                        return 2;
                    })
                    )).then(literal("farlands").executes(
                    context -> {
                        boolean FLC = GeneralManager.getConfig().farLandsEnabled.getValue();
                        context.getSource().sendFeedback(new LiteralText("FarLands " + getEnabledOrDisabled(!FLC)), true);
                        GeneralManager.getConfig().farLandsEnabled.setValue(!FLC);
                        return 1;
                    }).then(literal("shatter").executes(
                            context -> {
                                boolean SLC = GeneralManager.getConfig().shardFarLands.getValue();
                                if (SLC) {
                                    context.getSource().sendFeedback(new LiteralText("Shattered farlands disabled"), true);
                                } else {
                                    context.getSource().sendFeedback(new LiteralText("Shattered farlands enabled, teleport to x = 784444 or x/z 196111 to see them!"), true);
                                        }
                                GeneralManager.getConfig().shardFarLands.setValue(!SLC);
                                return 2;
                            }))
                    .then(literal("get").executes(
                            context -> {
                                context.getSource().sendFeedback(new LiteralText(
                                        "FarLands currently " + getEnabledOrDisabled(GeneralManager.getConfig().farLandsEnabled.getValue())
                                                + "\nShattered FarLands currently " +getEnabledOrDisabled(GeneralManager.getConfig().shardFarLands.getValue())
                                        //+ "\nFarlands will spawn at roughly " + (Integer.MAX_VALUE / 171.103d) + ", the shattered farlands at " + ((double)(Integer.MAX_VALUE/32)/171.103d) + ", and the fartherlands at " + (Integer.MAX_VALUE/171.103d)*80.0d

                                ), true);
                                return 0;
                            })
                    ))
                    .then(literal("toggleOpFireballs").executes(
                            context -> {
                                getConfig().fixFireballs.setValue(!getConfig().fixFireballs.getValue());
                                return 7;
                            }
                    ))
                    .then(
                            literal("doubleCoordinateScale".toLowerCase()).
                                    executes(
                                    context -> {
                                        GeneralManager.getConfig().coordinateScale.setValue(GeneralManager.getConfig().coordinateScale.getValue() * 2);

                                        return 2;
                                    }
                            )
                    ).then(
                            literal("resetCoordinateScale".toLowerCase()).
                                    executes(
                                            context -> {
                                                getConfig().coordinateScale.setValue(getConfig().coordinateScale.getDefaultValue());
                                                return -2;
                                            }
                                    )
                            )
            );
        });
    }
    public static String getEnabledOrDisabled(boolean bool) {
        if (bool) {
            return "enabled";
        } else if (!bool) {
            return "disabled";
        } else {
            throw new ArithmeticException("Input not a boolean!");
        }
    }
}
