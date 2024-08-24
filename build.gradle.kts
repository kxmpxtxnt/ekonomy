repositories {
  mavenCentral()
}

allprojects {
  this.group = "fyi.pauli"
  this.version = globalVersion
  this.description = "Ekonomy is a modification for minecraft economies."
}

tasks.register("fullPublish") {
  group = "ekonomy"
  listOf(
    "modrinth",
    "publishMavenPublicationToPauliRepository",
    "publishMavenPublicationToMavenCentralRepository",
  ).forEachIndexed { _, taskName ->
    subprojects.forEach { subProject ->
      val task = subProject.tasks.findByName(taskName) ?: return@forEach
      dependsOn(task.path)
    }
  }
}
