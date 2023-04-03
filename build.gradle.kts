plugins {
    kotlin("jvm") version "1.7.22"
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        version = "1.6.21"
    }
    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = "1.7.10"
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
    }
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "17"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_17.majorVersion
        }
    }

    repositories {
        mavenCentral()
    }
}