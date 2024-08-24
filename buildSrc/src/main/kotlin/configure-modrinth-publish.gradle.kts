plugins {
  kotlin("jvm")
  id("com.modrinth.minotaur")
}

repositories {
  mavenCentral()
}

modrinth {
  token = findProperty("modrinth.token").toString()

  projectId = modrinthProjectId

  versionType = releaseType
  gameVersions = supportedMinecraftVersions.split(",").map(String::trim).filter(String::isNotEmpty)
}