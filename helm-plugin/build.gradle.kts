plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("org.jetbrains.dokka")
    id("maven-publish")
}


dependencies {
    // @OUTDATED: latest version 2.1 https://bitbucket.org/snakeyaml/snakeyaml/wiki/Changes
    implementation("org.yaml:snakeyaml:1.27")
    // @REFACTOR: ? from 20200518 to this version - huge!
    implementation("org.json:json:20200518")

    // @REFACTOR
    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")

    testImplementation("com.jayway.jsonpath:json-path:2.4.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
    testImplementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.11.2")

    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")

    // @REFACTOR
    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}

gradlePlugin {
    plugins {
        create("helmCommandsPlugin") {
            id = "io.github.bullshit.helmng-commands"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.command.HelmCommandsPlugin"
            displayName = "Helm Commands plugin"
            tags.set(listOf("helm"))
            description =
                "Use Helm CLI commands directly as tasks, without any of the declarative DSL that the helm plugin offers."
        }
        create("helmPlugin") {
            id = "io.github.bullshit.helmng"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.HelmPlugin"
            displayName = "Helm plugin"
            tags.set(listOf("helm"))
            description =
                "This is the main plugin of the suite. It enables a variety of extra DSL blocks inside helm, for example charts and repositories."
        }
    }
}
