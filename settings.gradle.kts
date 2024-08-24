rootProject.name = "ekonomy"

include(
  "${rootProject.name}-api",
  "${rootProject.name}-paper",
  "${rootProject.name}-fabric",
  "${rootProject.name}-shared",
)

pluginManagement {
  repositories {
    gradlePluginPortal()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.parchmentmc.org/")
    maven("https://repo.papermc.io/repository/maven-public/")
  }
}