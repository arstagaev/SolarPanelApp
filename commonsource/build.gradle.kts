import com.arstagaev.gradle.Deps
import com.arstagaev.gradle.Configuration
import com.arstagaev.gradle.Versions

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlin-parcelize")
    id("app.cash.sqldelight")
    id("kotlinx-serialization")
}

kotlin {
    //targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "commonsource"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                // for domain logic actually
                implementation(Deps.Coroutines.core)
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.clientContentNegotiation)
                implementation(Deps.Ktor.serializationKotlinxJson)
                implementation(Deps.Ktor.clientLogging)
                api(Deps.Koin.core)
                implementation(Deps.KotlinX.serializationJson)



                with(Deps.SQLDelight) {
                    api(coroutinesExtensions)
                    api(primitiveAdapters)
                }
                // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-datetime
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            }
        }

        val androidMain by getting {
            dependencies {
                // ui
                implementation(Deps.Compose.ui)
                implementation(Deps.Compose.uiTooling)
                implementation(Deps.Compose.uiToolingPreview)
                implementation(Deps.Compose.foundation)
                implementation(Deps.Compose.material)
                implementation(Deps.Compose.activity)

                implementation(Deps.Ktor.engineClientAndroid)
                api(Deps.Koin.android)



                // SqlDelight
                implementation(Deps.SQLDelight.androidDriver)
                // Chart:
                // Includes the core logic for charts and other elements.
                implementation( "com.patrykandpatrick.vico:core:1.7.1")
                // For Jetpack Compose.
                implementation ("com.patrykandpatrick.vico:compose:1.7.1")
                // For the view system.
                implementation ("com.patrykandpatrick.vico:views:1.7.1")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies{
                dependsOn(commonMain)
                implementation(Deps.Ktor.engineClientDarwin)

                implementation(Deps.SQLDelight.nativeDriver)
            }
            //dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            //dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
//        }
    }
}

android {
    namespace = "com.arstagaev.solarpanelx"
    compileSdk = Configuration.compileSdk
    defaultConfig {
        minSdk = Configuration.minSdk
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

sqldelight {
    databases {
        create("WeatherDatabase") {
            //sqldelight/com/arstagaev/testkmm10/cache/WeatherDatabase.sq
            packageName.set("com.arstagaev.solarpanelx.cache")
        }
    }
}
