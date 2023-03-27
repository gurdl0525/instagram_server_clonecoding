plugins{
    id("org.springframework.boot") version "2.7.7"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}