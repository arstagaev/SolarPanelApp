pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}

rootProject.name = "Solarpanelx"
include(":androidApp")
include(":commonsource")
include(":feature:f_finance")
include(":feature:f_power_calc")
include(":feature:f_custom_ui")
include(":feature:f_nature_style")
include(":core")
