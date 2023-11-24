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
}

tasks.test {
    useTestNG()
}