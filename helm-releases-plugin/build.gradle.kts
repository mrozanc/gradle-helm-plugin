plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("org.jetbrains.dokka")
    id("maven-publish")
}


dependencies {

    implementation(project(":helm-plugin"))

    // @REFACTOR
    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")
    // @REFACTOR
    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}


gradlePlugin {

    plugins {
        create("helmReleasesPlugin") {
            id = "io.github.bullshit.helmng-releases"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.release.HelmReleasesPlugin"
            displayName = "Helm Releases Plugin"
            tags.set(listOf("helm"))
            description =
                "Use this plugin to manage Helm releases (install/upgrade/uninstall) on a remote Kubernetes cluster."
        }
    }
}
