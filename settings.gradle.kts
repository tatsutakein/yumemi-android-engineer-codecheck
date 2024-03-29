pluginManagement {
    includeBuild("build-logic")
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
rootProject.name = "Android Engineer CodeCheck"
include(":app")
include(":core:model")
include(":core:network")
include(":core:data")
include(":core:styleguide")
include(":core:testing")
include(":feature:github")
