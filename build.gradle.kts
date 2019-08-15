import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
    }
}

plugins {
    antlr
    kotlin("jvm") version "1.3.41"
}

group = "org.lite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.7.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-no-listener")
}

allprojects {
    repositories {
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/groups/public/")
        }
        maven {
            url = uri("http://maven.aliyun.com/nexus/content/repositories/jcenter")
        }
    }
}