plugins {
  `configure-fabric`
  `configure-modrinth-publish`
}

configurePlatform(modrinth, "fabric") {
  uploadFile = tasks.remapJar.get()
}
