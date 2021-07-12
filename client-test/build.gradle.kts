plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                progressiveMode = true
                useExperimentalAnnotation("kotlin.RequiresOptIn")
                useExperimentalAnnotation("com.algolia.search.InternalAlgoliaClientApi")
            }
        }
        val commonMain by getting {
            dependencies {
                api(project(":client"))
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
    }
}
