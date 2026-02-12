-injars test/s000386174.jar
-outjars test/s000386174_proguard.jar

-libraryjars /usr/lib/jvm/java-25-openjdk-amd64/jmods/java.base.jmod

-optimizationpasses 3
-dontobfuscate
-dontusemixedcaseclassnames
-dontpreverify



# Keep - Applications. Keep all application classes, along with their 'main' methods.
-keepclasseswithmembers public class * {
    public static void main(java.lang.String[]);
}

# Keep - Native method names. Keep all native class/method names.
-keepclasseswithmembers,includedescriptorclasses,allowshrinking class * {
    native <methods>;
}
