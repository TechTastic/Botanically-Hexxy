package io.github.techtastic.botanically_hexxy

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.techtastic.botanically_hexxy.config.BotanicallyHexxyServerConfig
import io.github.techtastic.botanically_hexxy.networking.BotanicallyHexxyNetworking
import io.github.techtastic.botanically_hexxy.registry.BotanicallyHexxyActions

object BotanicallyHexxy {
    const val MODID = "botanically_hexxy"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        BotanicallyHexxyServerConfig.init()
        initRegistries(
            BotanicallyHexxyActions,
        )
        BotanicallyHexxyNetworking.init()
    }

    fun initServer() {
        BotanicallyHexxyServerConfig.initServer()
    }
}
