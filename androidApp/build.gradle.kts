import com.arstagaev.solarpanelx.Deps
import com.arstagaev.solarpanelx.Configuration
import com.arstagaev.solarpanelx.Versions

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.arstagaev.solarpanelx.android"
    compileSdk = Configuration.compileSdk
    defaultConfig {
        applicationId = "com.arstagaev.solarpanelx.android"
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
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

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    implementation(Deps.Decompose.main)
    implementation(Deps.Decompose.ext)
}