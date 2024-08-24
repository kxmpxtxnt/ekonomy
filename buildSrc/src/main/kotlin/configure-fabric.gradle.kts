import gradle.kotlin.dsl.accessors._67ca541ef713fe1406dfc8b853dc10c1.modrinth
import gradle.kotlin.dsl.accessors._67ca541ef713fe1406dfc8b853dc10c1.processResources
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("fabric-loom")
}

dependencies {
  minecraft("com.mojang", "minecraft", minecraftVersion)
  mappings(loom.layered {
    officialMojangMappings()
  })
  modImplementation("net.fabricmc", "fabric-loader", fabricLoaderVersion)
  modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)
}

tasks {
  processResources {
    val props = mapOf(
      "github" to gitRepo,
      "id" to rootProject.name,
      "name" to rootProject.name,
      "version" to rootProject.version,
      "mc" to supportedMinecraftVersionRange,
      "description" to rootProject.description,
    )

    props.forEach(inputs::property)

    filesMatching("fabric.mod.json") {
      expand(props)
    }
  }

  withType<JavaCompile> {
    options.release = javaVersion.toInt()
  }

  withType<KotlinCompile> {
    compilerOptions.jvmTarget = JvmTarget.fromTarget(javaVersion)
  }
}

java {
  withSourcesJar()

  javaVersion.toInt().let { JavaVersion.values()[it - 1] }.let {
    sourceCompatibility = it
    targetCompatibility = it
  }
}