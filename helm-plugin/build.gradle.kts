plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("org.jetbrains.dokka")
    id("maven-publish")
}


dependencies {

    implementation("org.yaml:snakeyaml:1.27")
    implementation("org.json:json:20200518")

    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")

    testImplementation("com.jayway.jsonpath:json-path:2.4.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.11.2")

    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")

    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}


gradlePlugin {
    plugins {
        create("helmCommandsPlugin") {
            id = "io.github.mehmetsalgar.helm-commands"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.command.HelmCommandsPlugin"
            displayName = "Helm Commands plugin"
        }
        create("helmPlugin") {
            id = "io.github.mehmetsalgar.helm"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.HelmPlugin"
            displayName = "Helm plugin"
        }
    }
}
