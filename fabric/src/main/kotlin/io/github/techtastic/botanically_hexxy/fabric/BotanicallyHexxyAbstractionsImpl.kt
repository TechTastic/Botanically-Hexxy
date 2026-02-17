@file:JvmName("BotanicallyHexxyAbstractionsImpl")

package io.github.techtastic.botanically_hexxy.fabric

import io.github.techtastic.botanically_hexxy.registry.BotanicallyHexxyRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: BotanicallyHexxyRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
