plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

//@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    //targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "core"
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(project(":commonsource"))

                //implementation(project(":feature:f_finance"))
                //implementation(project(":feature:f_custom_ui"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {

                implementation(project(":feature:f_finance"))
                implementation(project(":feature:f_custom_ui"))

                // ui
                implementation(com.arstagaev.gradle.Deps.Compose.ui)
                implementation(com.arstagaev.gradle.Deps.Compose.uiTooling)
                implementation(com.arstagaev.gradle.Deps.Compose.uiToolingPreview)
                implementation(com.arstagaev.gradle.Deps.Compose.foundation)
                implementation(com.arstagaev.gradle.Deps.Compose.material)
                implementation(com.arstagaev.gradle.Deps.Compose.activity)

                implementation(com.arstagaev.gradle.Deps.Ktor.engineClientAndroid)
                api(com.arstagaev.gradle.Deps.Koin.android)

                implementation(com.arstagaev.gradle.Deps.Decompose.main)
                implementation(com.arstagaev.gradle.Deps.Decompose.ext)

                // SqlDelight
                implementation(com.arstagaev.gradle.Deps.SQLDelight.androidDriver)
                // Chart:
                // Includes the core logic for charts and other elements.
                implementation( "com.patrykandpatrick.vico:core:1.7.1")
                // For Jetpack Compose.
                implementation ("com.patrykandpatrick.vico:compose:1.7.1")
                // For the view system.
                implementation ("com.patrykandpatrick.vico:views:1.7.1")
            }
        }
    }
}

android {
    namespace = "com.arstagaev.solarpanelx"
    compileSdk = com.arstagaev.gradle.Configuration.compileSdk
    defaultConfig {
        minSdk = com.arstagaev.gradle.Configuration.minSdk
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.arstagaev.gradle.Versions.composeCompiler
    }
}