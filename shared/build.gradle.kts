plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id ("kotlinx-serialization")
}

kotlin {
    jvmToolchain(11)
    android {
        java {
            toolchain.languageVersion.set(JavaLanguageVersion.of(11))
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        val sqlDelightVersion = "1.5.5"
        val kotlinxSerialization = "1.5.0"
        val commonMain by getting {
            dependencies{

                //atomic fu workaround
                implementation("org.jetbrains.kotlinx:atomicfu:0.18.5")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$kotlinxSerialization")
//                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                api("moe.tlaster:precompose:1.3.14")
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.animation)
                implementation(compose.material)
                implementation(compose.material3)
                implementation(compose.runtime)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

            }
        }
        val commonTest by getting {
            dependencies {

                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }

}

android {
    namespace = "com.abdulaziz.trivia"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
    }
}


//sqldelight {
//    database("AppDatabase") {
//        packageName = "com.abdulaziz.trivia.database"
//        sourceFolders = listOf("sqldelight")
//    }
//    linkSqlite = true
//}