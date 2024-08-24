import com.modrinth.minotaur.ModrinthExtension
import com.modrinth.minotaur.dependencies.DependencyType
import com.modrinth.minotaur.dependencies.ModDependency
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import java.io.File

fun Project.configurePlatform(
  modrinth: ModrinthExtension,
  platform: String,
  apply: ModrinthExtension.() -> Unit = { },
) {
  modrinth.versionName = "${rootProject.name}-$platform-$globalVersion"
  val specificChangeLog: File = file("../changelogs/$platform/$globalVersion.md")

  modrinth.changelog = file("../changelogs/$globalVersion.md").readText() +
      if (specificChangeLog.exists()) specificChangeLog.readText() else ""

  when (platform) {
    "fabric" -> modrinth.dependencies = listOf(
      ModDependency("P7dR8mSH", DependencyType.REQUIRED), // Fabric API
      ModDependency("Ha28R6CL", DependencyType.REQUIRED), // Fabric Language Kotlin
    )

    else -> {}
  }

  modrinth.apply()
}