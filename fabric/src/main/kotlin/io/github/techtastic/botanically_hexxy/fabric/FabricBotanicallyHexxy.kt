package io.github.techtastic.botanically_hexxy.fabric

import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import net.fabricmc.api.ModInitializer

object FabricBotanicallyHexxy : ModInitializer {
    override fun onInitialize() {
        BotanicallyHexxy.init()
    }
}
