pluginManagement {

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy.eachPlugin {
        if (requested.id.namespace == "org.jetbrains.kotlin" ||
                requested.id.namespace.orEmpty().startsWith("org.jetbrains.kotlin.")) {
            useVersion(embeddedKotlinVersion)
        }
    }
}

buildCache {
    val isCiServer = System.getenv().containsKey("CI")
    System.getenv("GRADLE_CACHE_URL")?.let { cacheUrl ->
        remote<HttpBuildCache> {
            url = uri(cacheUrl)
            isPush = isCiServer
            System.getenv("GRADLE_CACHE_USER")?.let { cacheUser ->
                credentials {
                    username = cacheUser
                    password = System.getenv("GRADLE_CACHE_PASSWORD")
                }
            }
        }
    }
}

rootProject.name = "gradle-helm-plugin-parent"

include(
    "helm-plugin",
    "helm-publish-plugin",
    "helm-releases-plugin"
)
