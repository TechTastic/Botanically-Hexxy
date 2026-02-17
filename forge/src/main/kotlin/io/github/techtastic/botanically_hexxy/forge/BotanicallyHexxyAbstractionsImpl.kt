@file:JvmName("BotanicallyHexxyAbstractionsImpl")

package io.github.techtastic.botanically_hexxy.forge

import io.github.techtastic.botanically_hexxy.registry.BotanicallyHexxyRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: BotanicallyHexxyRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
