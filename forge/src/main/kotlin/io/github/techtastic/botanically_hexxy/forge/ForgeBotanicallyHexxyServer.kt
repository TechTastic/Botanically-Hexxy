package io.github.techtastic.botanically_hexxy.forge

import io.github.techtastic.botanically_hexxy.BotanicallyHexxy
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeBotanicallyHexxyServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        BotanicallyHexxy.initServer()
    }
}
