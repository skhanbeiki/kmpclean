import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.File

apply(from = "project_configs.gradle.kts")

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    // alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlinSerialization)
}

// --- Code Generation for ProjectConfig ---
val projectKeyProp = project.findProperty("projectKey")?.toString() ?: "WATER_CAFEBAZAAR"

val generateProjectConfig = tasks.register("generateProjectConfig") {
    val outputDir = File(project.layout.buildDirectory.asFile.get(), "generated/projectConfig/commonMain/kotlin/ir/khanbeiki/kmpclean/platform/config")
    outputs.dir(outputDir)

    doLast {
        val configs = project.extra.get("projectConfigs") as Map<String, Map<String, String>>
        val config = configs[projectKeyProp] ?: configs["WATER_CAFEBAZAAR"]!!

        val configFile = File(outputDir, "ActualProjectConfig.kt")
        configFile.parentFile.mkdirs()

        val content = """
            package ir.khanbeiki.kmpclean.platform.config
            
            import androidx.compose.ui.graphics.Color
            import ir.khanbeiki.kmpclean.core.base.ProjectConfig
            
            object ActualProjectConfig : ProjectConfig {
                override val appName = "${config["appName"]}"
                override val baseUrl = "${config["baseUrl"]}"
                override val marketName = "${config["marketName"]}"
                override val primaryColor = Color(${config["primaryColor"]})
                override val backgroundColor = Color(${config["backgroundColor"]})
                override val textPrimaryColor = Color(${config["textPrimaryColor"]})
                override val titleFa = "${config["titleFa"]}"
                override val titleEn = "${config["titleEn"]}"
                override val descriptionFa = "${config["descriptionFa"]}"
                override val descriptionEn = "${config["descriptionEn"]}"
                override val logoRes = "${config["logoRes"]}"
            }
        """.trimIndent()

        configFile.writeText(content)
    }
}

kotlin {
    // Register generated source set
    sourceSets.commonMain {
        kotlin.srcDir(generateProjectConfig)
    }
    
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
    js {
        browser()
        binaries.executable()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(project(":core:domain"))
            implementation(project(":core:data"))
            implementation(project(":core:network"))
            implementation(project(":core:common"))
            implementation(project(":core:base"))
            implementation(project(":library:designsystem"))
            implementation(project(":library:navigation"))
            implementation(project(":feature:home"))
            implementation(project(":feature:payment"))
            implementation(project(":feature:inquiry"))
            implementation(project(":feature:registration"))

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            
            // Voyager
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenModel)
            implementation(libs.voyager.bottomSheetNavigator)
            implementation(libs.voyager.tabNavigator)
            implementation(libs.voyager.transitions)
            implementation(libs.voyager.koin)

            // Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            // Koin
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // Coil
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        jsMain.dependencies {
            implementation(libs.ktor.client.js)
        }
    }
}

android {
    namespace = "ir.khanbeiki.kmpclean"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "ir.khanbeiki.kmpclean"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    flavorDimensions += "variant"

    val projects = listOf("water", "electricity", "gas", "phone", "mobile")
    val markets = listOf("Cafebazaar", "Myket", "Playstore")
    val packageNameBase = "ir.khanbeiki.kmpclean."

    productFlavors {
        projects.forEach { p ->
            markets.forEach { m ->
                create("$p$m") {
                    dimension = "variant"
                    applicationId = "$packageNameBase$p"
                    versionCode = 1
                    versionName = "1.0.0"

                    val key = "${p.uppercase()}_${m.uppercase()}"
                    val configs = project.extra.get("projectConfigs") as Map<String, Map<String, String>>
                    val config = configs[key] ?: configs["WATER_CAFEBAZAAR"]!!

                    buildConfigField("String", "PROJECT_KEY", "\"$key\"")
                    buildConfigField("String", "APP_NAME", "\"${config["appName"]}\"")
                    buildConfigField("String", "BASE_URL", "\"${config["baseUrl"]}\"")
                    buildConfigField("String", "MARKET_NAME", "\"${config["marketName"]}\"")
                    buildConfigField("String", "PRIMARY_COLOR", "\"${config["primaryColor"]}\"")
                    buildConfigField("String", "BACKGROUND_COLOR", "\"${config["backgroundColor"]}\"")
                    buildConfigField("String", "TEXT_PRIMARY_COLOR", "\"${config["textPrimaryColor"]}\"")
                    buildConfigField("String", "TITLE_FA", "\"${config["titleFa"]}\"")
                    buildConfigField("String", "TITLE_EN", "\"${config["titleEn"]}\"")
                    buildConfigField("String", "DESCRIPTION_FA", "\"${config["descriptionFa"]}\"")
                    buildConfigField("String", "DESCRIPTION_EN", "\"${config["descriptionEn"]}\"")
                    buildConfigField("String", "LOGO_RES", "\"${config["logoRes"]}\"")
                }
            }
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "ir.khanbeiki.myapplication.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ir.khanbeiki.myapplication"
            packageVersion = "1.0.0"
        }
    }
}
