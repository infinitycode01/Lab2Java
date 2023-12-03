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

    implementation("com.google.code.gson:gson:2.10.1")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0")

    implementation("org.hibernate:hibernate-validator:8.0.0.Final")
    implementation ("org.glassfish:jakarta.el:4.0.2")
    implementation ("org.hibernate.validator:hibernate-validator:8.0.0.Final")
    //implementation ("jakarta.validation:jakarta.validation-api:4.0.0")




}

tasks.test {
    useTestNG()
}