package io.github.techtastic.botanically_hexxy.fabric

import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import net.fabricmc.api.DedicatedServerModInitializer

object FabricBotanicallyHexxyServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        BotanicallyHexxy.initServer()
    }
}
