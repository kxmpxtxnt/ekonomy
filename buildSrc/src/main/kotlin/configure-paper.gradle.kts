import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
  kotlin("jvm")
  id("xyz.jpenilla.run-paper")
  id("io.papermc.paperweight.userdev")
  id("net.minecrell.plugin-yml.paper")
}

repositories {
  maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
  paperLibrary(kotlin("stdlib"))
  paperweight.paperDevBundle("1.21.1-R0.1-SNAPSHOT")
  paperLibrary("net.axay", "kspigot", "1.21.0")
}

tasks {
  kotlin {
    jvmToolchain(21)
  }

  assemble {
    dependsOn(reobfJar)
  }

  paper {
    name = rootProject.name
    description = rootProject.description

    main = "fyi.pauli.ekonomy.Ekonomy"

    version = globalVersion
    authors = globalAuthors

    apiVersion = minecraftVersion.run {
      if (split(".").count() >= 2) substringBeforeLast(".") else this
    }

    generateLibrariesJson = true
    loader = "fyi.pauli.ekonomy.EkonomyLoader"

    foliaSupported = true

    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
  }
}