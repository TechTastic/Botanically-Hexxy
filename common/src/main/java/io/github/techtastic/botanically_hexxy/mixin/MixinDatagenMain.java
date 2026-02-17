package io.github.techtastic.botanically_hexxy.mixin;

import io.github.techtastic.botanically_hexxy.BotanicallyHexxy;
import org.spongepowered.asm.mixin.Mixin;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin({
    net.minecraft.data.Main.class,
    net.minecraft.server.Main.class,
})
public abstract class MixinDatagenMain {
    @WrapMethod(method = "main", remap = false)
    private static void botanically_hexxy$systemExitAfterDatagenFinishes(String[] strings, Operation<Void> original) {
        try {
            original.call((Object) strings);
        } catch (Throwable throwable) {
            BotanicallyHexxy.LOGGER.error("Datagen failed!", throwable);
            System.exit(1);
        }
        BotanicallyHexxy.LOGGER.info("Datagen succeeded, terminating.");
        System.exit(0);
    }
}
