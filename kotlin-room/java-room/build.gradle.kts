

buildscript {
    repositories {
        mavenCentral() // add repository
    }
    dependencies {
//        classpath 'com.android.tools.build:gradle:<agp-version>'
        classpath("org.greenrobot:greendao-gradle-plugin:3.3.1") // add plugin
    }
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("org.greenrobot.greendao") version ("3.3.1") apply false
}


android {
    namespace = "com.junli.java_room"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.junli.java_room"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        create("customDebugType") {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    greendao {
//        var schemaVersion = 1 //数据库版本号 每次升级数据库都需要改变版本，只能增加
//        var daoPackage = "com.example.greendao"  //设置DaoMaster、DaoSession、Dao包名
//        var targetGenDir = "sr/main/java" //设置DaoMaster、DaoSession、Dao目录
//    }

}
dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation(project(":app"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Room框架
    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    //GreenDao
    implementation("org.greenrobot:greendao:3.3.1")
}

