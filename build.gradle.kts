plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.30") // Versão mais recente até ago/2025
    annotationProcessor("org.projectlombok:lombok:1.18.30")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
// Estende compileOnly da annotationProcessor (boa prática, mas opcional)
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }

    }

tasks.test {
    useJUnitPlatform()
}