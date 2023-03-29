plugins {
    kotlin("plugin.allopen") version "1.6.21"
}


dependencies {
    implementation(project(":instagram-domain"))
    implementation("org.springframework:spring-tx:6.0.3")
}

allOpen {
    annotation("com.example.instagram.global.annotation.UseCase")
}
