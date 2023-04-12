plugins {
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish")
    id("org.jetbrains.dokka")
    id("maven-publish")
}


dependencies {
    implementation(project(":helm-plugin"))

    implementation("com.squareup.okhttp3:okhttp:4.9.0") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-common")
    }
    implementation("com.squareup.okhttp3:okhttp-tls:4.9.0") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-common")
    }

    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")

    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}
/*
dependencies {
    implementation(project(":helm-plugin"))

    // @OUTDATED ?
    implementation("com.squareup.okhttp3:okhttp:4.9.3") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-common")
    }
    // @OUTDATED ?
    implementation("com.squareup.okhttp3:okhttp-tls:4.9.3") {
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib")
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-common")
    }

    // @REFACTOR
    implementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-utils:0.5.0")
    // @REFACTOR
    testImplementation("org.unbroken-dome.gradle-plugin-utils:gradle-plugin-test-utils:0.5.0")
}
 */

gradlePlugin {
    plugins {
        create("helmPublishPlugin") {
            id = "io.github.bullshit.helmng-publish"
            implementationClass = "org.unbrokendome.gradle.plugins.helm.publishing.HelmPublishPlugin"
            displayName = "Helm Publish Plugin"
            tags.set(listOf("helm"))
            description = "Use this plugin to publish charts to a remote chart repository like ChartMuseum."
        }
    }
}
