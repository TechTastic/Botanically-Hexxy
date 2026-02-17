@file:JvmName("BotanicallyHexxyAbstractions")

package io.github.techtastic.botanically_hexxy

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.techtastic.botanically_hexxy.registry.BotanicallyHexxyRegistrar

fun initRegistries(vararg registries: BotanicallyHexxyRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: BotanicallyHexxyRegistrar<T>) {
    throw AssertionError()
}
