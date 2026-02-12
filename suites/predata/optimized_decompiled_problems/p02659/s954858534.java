import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static long mod;
    
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).nextLine().split(" ");
        System.out.println(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L);
    }
}
