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

rootProject.name = "MovieShows"
include(":app")
include(":core")
include(":core:data")
include(":core:network")
include(":core:database")
include(":core:domain")
include(":core:domain")
