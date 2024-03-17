import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

group = "com.flow-health"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // annotation processor
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    // feign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.5")
    implementation("io.github.openfeign:feign-httpclient:11.10")

    // cloud
    implementation("org.springframework.cloud:spring-cloud-dependencies:2021.0.5")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
