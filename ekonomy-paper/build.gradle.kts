plugins {
  `configure-paper`
  `configure-modrinth-publish`
}

configurePlatform(modrinth, "paper") {
  uploadFile = tasks.jar.get()
}