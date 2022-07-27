import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.google.protobuf") version "0.8.19"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.19")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("com.google.protobuf:protobuf-kotlin:3.21.4")
}


protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.4"
    }

    plugins {
        id("kotlin")
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("kotlin")
            }
        }
    }
}