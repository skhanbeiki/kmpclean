import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    // alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
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

    val cafebazaar = "Cafebazaar"
    val myket = "Myket"
    val playstore = "Playstore"
    val packageNameBase = "ir.khanbeiki.kmpclean."

    productFlavors {
        // Water
        create("water$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameBase}water"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("water$myket") {
            dimension = "variant"
            applicationId = "${packageNameBase}water"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("water$playstore") {
            dimension = "variant"
            applicationId = "${packageNameBase}water"
            versionCode = 1
            versionName = "1.0.0"
        }

        // Electricity
        create("electricity$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameBase}electricity"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("electricity$myket") {
            dimension = "variant"
            applicationId = "${packageNameBase}electricity"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("electricity$playstore") {
            dimension = "variant"
            applicationId = "${packageNameBase}electricity"
            versionCode = 1
            versionName = "1.0.0"
        }
        
        // Gas
        create("gas$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameBase}gas"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("gas$myket") {
            dimension = "variant"
            applicationId = "${packageNameBase}gas"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("gas$playstore") {
            dimension = "variant"
            applicationId = "${packageNameBase}gas"
            versionCode = 1
            versionName = "1.0.0"
        }

        // Phone
        create("phone$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameBase}phone"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("phone$myket") {
            dimension = "variant"
            applicationId = "${packageNameBase}phone"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("phone$playstore") {
            dimension = "variant"
            applicationId = "${packageNameBase}phone"
            versionCode = 1
            versionName = "1.0.0"
        }

        // Mobile
        create("mobile$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameBase}mobile"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("mobile$myket") {
            dimension = "variant"
            applicationId = "${packageNameBase}mobile"
            versionCode = 1
            versionName = "1.0.0"
        }
        create("mobile$playstore") {
            dimension = "variant"
            applicationId = "${packageNameBase}mobile"
            versionCode = 1
            versionName = "1.0.0"
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
