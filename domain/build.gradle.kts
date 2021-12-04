plugins {
    id(Plugins.JAVA_LIBRARY)
    id(Plugins.KOTLIN)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    api(AppDependencies.androidLibraries)
    api(project(mapOf("path" to AppDependencies.UTIL)))
}