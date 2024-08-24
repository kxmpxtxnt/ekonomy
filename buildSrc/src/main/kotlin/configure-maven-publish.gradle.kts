import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.Platform
import com.vanniktech.maven.publish.SonatypeHost
import java.net.URI

plugins {
  signing
  kotlin("jvm")
  `maven-publish`
  id("com.vanniktech.maven.publish")
}

repositories {
  mavenCentral()
}

publishing {
  repositories {
    maven {
      name = "pauli"

      credentials {
        password = property("pauliPassword").toString()
        username = property("pauliUsername").toString()
      }

      url = URI.create(
        if (snapshot)
          "https://repo.pauli.fyi/snapshots"
        else
          "https://repo.pauli.fyi/releases"
      )
    }
  }

  publications {
    register<MavenPublication>(project.name) {
      from(components["java"])


      this.groupId = project.group.toString()
      this.artifactId = project.name
      this.version = rootProject.version.toString()


      pom {
        name = project.name
        description = project.description

        developers {
          globalAuthors.forEach {
            developer {
              name = it
            }
          }
        }

        licenses {
          license {
            name = "GNU General Public License 3"
            url = "https://www.gnu.org/licenses/gpl-3.0.txt"
          }
        }

        url = "https://github.com/$gitRepo"

        scm {
          connection = "scm:git:git//github.com/$gitRepo.git"
          url = "${this@pom.url}/tree/main"
        }
      }
    }
  }
}

mavenPublishing {
  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

  signAllPublications()

  coordinates(project.group.toString(), project.name, rootProject.version.toString())

  pom {
    name = project.name
    description = project.description

    developers {
      globalAuthors.forEach {
        developer {
          name = it
        }
      }
    }

    licenses {
      license {
        name = "GNU General Public License 3"
        url = "https://www.gnu.org/licenses/gpl-3.0.txt"
      }
    }

    url = "https://github.com/$gitRepo"

    scm {
      connection = "scm:git:git//github.com/$gitRepo.git"
      url = "${this@pom.url}/tree/main"
    }
  }
}