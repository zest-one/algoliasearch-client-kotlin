plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.vanniktech.maven.publish")
}

kotlin {
    explicitApi()
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure { useJUnit() }
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
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                api(libs.ktor.client.okhttp)
            }
        }
    }
}
