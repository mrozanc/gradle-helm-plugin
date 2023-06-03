plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("org.jetbrains.dokka")
    id("maven-publish")
}


dependencies {

    implementation("org.yaml:snakeyaml:2.0")
    implementation("org.json:json:20230227")

    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")

    testImplementation("com.jayway.jsonpath:json-path:2.8.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.1")

    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")

    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}


gradlePlugin {

    plugins {
        create("helmCommandsPlugin") {
            id = "fr.rozanc.helm-commands"
            displayName = "Helm Commands plugin"
            description = "Helm Commands plugin"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.command.HelmCommandsPlugin"
        }
        create("helmPlugin") {
            id = "fr.rozanc.helm"
            displayName = "Helm plugin"
            description = "Helm plugin"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.HelmPlugin"
        }
    }
}
