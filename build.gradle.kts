import xyz.deftu.gradle.utils.GameSide

plugins {
    java
    kotlin("jvm") version("1.6.21")
    `maven-publish`
    val dgtVersion = "1.10.4"
    id("xyz.deftu.gradle.tools") version(dgtVersion)
    id("xyz.deftu.gradle.tools.shadow") version(dgtVersion)
    id("xyz.deftu.gradle.tools.blossom") version(dgtVersion)
    id("xyz.deftu.gradle.tools.minecraft.api") version(dgtVersion)
    id("xyz.deftu.gradle.tools.minecraft.loom") version(dgtVersion)
    id("xyz.deftu.gradle.tools.minecraft.releases") version(dgtVersion)
}

deftu.useDevAuth()
loomApi.setupTestClient()

loomHelper {
    useForgeMixin(modData.id)
    useMixinRefMap(modData.id)
    useProperty("mixin.debug.export", "true", GameSide.CLIENT)
    useTweaker("cc.polyfrost.oneconfig.loader.stage0.LaunchWrapperTweaker")
    disableRunConfigs(GameSide.SERVER)
}

// create "api" source set
// make it have the same compile classpath as the main source set
// make the main source set depend on the api source set
sourceSets {
    val api by creating {
        compileClasspath += main.get().compileClasspath
        runtimeClasspath += main.get().runtimeClasspath
    }

    main {
        compileClasspath += api.output
        runtimeClasspath += api.output
    }

    named("testMod") {
        compileClasspath += api.output
        runtimeClasspath += api.output
    }
}

repositories {
    maven("https://repo.polyfrost.cc/releases")
}

dependencies {
    modCompileOnly("cc.polyfrost:oneconfig-${mcData.versionStr}-${mcData.loader.name}:0.2.0-alpha+")
    implementation(shade("cc.polyfrost:oneconfig-wrapper-launchwrapper:1.0.0-beta+")!!)
}

releases {
    github {
        owner.set("Deftu")
        repository.set("SBPI")
    }
}
