plugins {
  `kotlin-dsl`
  kotlin("plugin.serialization") version embeddedKotlinVersion
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  maven("https://maven.fabricmc.net/")
  maven("https://maven.quiltmc.org/repository/release")
  maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
  fun gradlePlugin(id: String, version: String) = "$id:$id.gradle.plugin:$version"

  val kotlinVersion = "2.0.20"

  runtimeOnly(kotlin("gradle-plugin", kotlinVersion))
  compileOnly(kotlin("gradle-plugin", embeddedKotlinVersion))
  runtimeOnly(gradlePlugin("org.jetbrains.kotlin.plugin.serialization", kotlinVersion))
  compileOnly(gradlePlugin("org.jetbrains.kotlin.plugin.serialization", embeddedKotlinVersion))

  implementation(gradlePlugin("fabric-loom", "1.7.3"))
  implementation(gradlePlugin("com.modrinth.minotaur", "2.8.7"))

  implementation(gradlePlugin("xyz.jpenilla.run-paper", "2.3.1"))
  implementation(gradlePlugin("io.papermc.paperweight.userdev", "1.7.2"))
  implementation(gradlePlugin("net.minecrell.plugin-yml.paper", "0.6.0"))

  implementation(gradlePlugin("com.vanniktech.maven.publish", "0.29.0"))
}