const val globalVersion = "0.0.1"

val snapshot: Boolean = globalVersion.endsWith("-SNAPSHOT")
val releaseType: String = if (snapshot || globalVersion.startsWith("0")) "beta" else "release"

const val modrinthProjectId: String = "pVPmMy8b"

const val gitRepo: String = "kxmpxtxnt/ekonomy"

val globalAuthors: List<String> = listOf(
  "kxmpxtxnt"
)

const val minecraftVersion: String = "1.21.1"
const val supportedMinecraftVersions: String = "1.21.1"
const val supportedMinecraftVersionRange: String = ">=1.21.1"

const val supportedLoaders: String = "fabric, paper, quilt"

const val fabricLoaderVersion: String = "0.16.2"
const val fabricKotlinVersion: String = "1.12.0+kotlin.2.0.10"

const val javaVersion: String = "21"