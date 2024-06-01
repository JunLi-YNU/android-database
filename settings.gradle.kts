pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android-database"
include(":app")
include(":module-base:java-room")
include(":module-base:kotlin-room")
include(":kotlin-room:kotlin-room")
include(":kotlin-room:java-room")
