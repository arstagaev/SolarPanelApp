import com.arstagaev.gradle.Deps

plugins {
    //`kotlin-dsl`
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.arstagaev.solarpanelx.android"
    compileSdk = com.arstagaev.gradle.Configuration.compileSdk
    defaultConfig {
        //applicationId = "com.arstagaev.solarpanelx.android"
        minSdk = com.arstagaev.gradle.Configuration.minSdk
        targetSdk = com.arstagaev.gradle.Configuration.targetSdk
        //versionCode = 1
        //versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.arstagaev.gradle.Versions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

repositories {
    google()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenCentral()
}
//kotlin {
//    sourceSets()
//}
dependencies {
    implementation(project(":commonsource"))
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
}