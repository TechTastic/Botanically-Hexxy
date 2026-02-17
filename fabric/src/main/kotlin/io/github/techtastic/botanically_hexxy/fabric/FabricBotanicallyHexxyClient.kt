package io.github.techtastic.botanically_hexxy.fabric

import io.github.techtastic.botanically_hexxy.BotanicallyHexxyClient
import net.fabricmc.api.ClientModInitializer

object FabricBotanicallyHexxyClient : ClientModInitializer {
    override fun onInitializeClient() {
        BotanicallyHexxyClient.init()
    }
}
