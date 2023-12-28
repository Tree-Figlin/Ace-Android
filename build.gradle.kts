// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(ProjectProperties.Gradle.APPLICATION) version Versions.GRADLE_ANDROID apply false
    id(ProjectProperties.Gradle.LIBRARY) version Versions.GRADLE_ANDROID apply false
    id(ProjectProperties.Gradle.KOTLIN) version Versions.GRADLE_KOTLIN apply false
    id(ProjectProperties.Gradle.HILT) version Versions.HILT apply false
    id(ProjectProperties.Gradle.GMS_GOOGLE_SERVICE) version Versions.GMS_GOOGLE_SERVICE apply false
    id(ProjectProperties.Gradle.GMS_GOOGLE_MAP) version Versions.GMS_GOOGLE_MAP_PULGIN apply false
}