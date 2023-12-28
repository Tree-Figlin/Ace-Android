import java.io.FileInputStream
import java.util.Properties

plugins {
    id(ProjectProperties.Gradle.KOTLIN)
    id(ProjectProperties.Gradle.LIBRARY)
    id(ProjectProperties.Gradle.HILT)
    id(ProjectProperties.Gradle.GMS_GOOGLE_MAP)
    kotlin(ProjectProperties.Gradle.KAPT)
}

android {
    namespace = ProjectProperties.Gradle.PERSENTATION
    compileSdk = ProjectProperties.Versions.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = ProjectProperties.Versions.MIN_SDK_VERSION

        testInstrumentationRunner = ProjectProperties.TestProperties.TEST_RUNNER
        consumerProguardFiles(ProjectProperties.Files.CONSUMER_PROGUARDFILES)
        vectorDrawables {
            useSupportLibrary = true
        }
        manifestPlaceholders["googleMapApiKey"] = getApiKey("GOOGLE_API_KEY")

        buildConfigField(
            "String",
            "NEWS_API_KEY",
            getApiKey("NEWS_API_KEY")
        )
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.Files.DEFAULT_PROGUARDFILES),
                ProjectProperties.Files.PROGUARDFILES
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.Versions.JAVA_VERSION
        targetCompatibility = ProjectProperties.Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.Versions.JVM_TARGET
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":design-system"))

    //hilt
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_ANDROID_COMPILER)

    //google map
    implementation(Dependency.Google.GMS_GOOGLE_MAP)
    implementation(Dependency.Google.GMS_GOOGLE_MAP_LOCATION)
    implementation(Dependency.Google.GMS_GOOGLE_MAP_COMPSE)

    //aac
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.Navigation.NAVIGATION)

    //compose
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_TOOLING)
    implementation(Dependency.Compose.COMPOSE_MATERIAL)
    implementation(Dependency.Compose.COMPOSE_MATERIAL3)
    implementation(Dependency.Compose.COMPOSE_PREVIEW)

    //junit
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO_CORE)
    androidTestImplementation(Dependency.Test.COMPOSE_JUNIT)
    debugImplementation(Dependency.Compose.COMPOSE_TOOLING)
    debugImplementation(Dependency.Test.COMPOSE_MANIFEST)

    //accompanist
    implementation(Dependency.Google.ACCOMPANIST)
    implementation(Dependency.Google.ACCOMPANIST_PERMISSION)

    //gson
    implementation(Dependency.Google.GSON)

    //coil
    implementation(Dependency.Image.COIL)

    //splash
    implementation(Dependency.AndroidX.SPLASH)
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}