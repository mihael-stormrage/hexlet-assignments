import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    checkstyle
    application
    id("com.github.ben-manes.versions") version "0.48.0"
}

group = "exercise"

version = "1.0-SNAPSHOT"

application { mainClass.set("exercise.Application") }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

checkstyle {
    toolVersion = "8.41"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.register<Checkstyle>("checkExercises") {
    file(".").listFiles { file -> file.isDirectory }?.forEach { course ->
        val exercise = (project.findProperty("exercise") ?: "") as String
        source(course.name + '/' + exercise)
        include("**/*.java")
        exclude("**/build/**")
        exclude("**/generated/**")
        classpath = files()
    }
}
