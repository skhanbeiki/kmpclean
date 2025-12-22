rootProject.name = "KmpClean"

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

include(":composeApp")
include(":core:base")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:network")
include(":feature:home")
include(":feature:inquiry")
include(":feature:payment")
include(":feature:registration")
include(":library:designsystem")
include(":library:navigation")
