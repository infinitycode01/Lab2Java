plugins {
    id("java")
}

group = "com.infinity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.7.0")

    implementation("org.slf4j:slf4j-api:2.0.5")
    implementation("org.slf4j:slf4j-simple:2.0.5")

    implementation ("com.google.code.gson:gson:2.8.9")

    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")
}

tasks.test {
    useTestNG()
}