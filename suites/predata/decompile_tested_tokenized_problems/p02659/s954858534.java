import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    static long mod;
    
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).nextLine().split(" ");
        System.out.println(Long.parseLong(split[0]) * Long.parseLong(split[1].replaceAll("\\.", "")) / 100L);
    }
    
    static {
        Main.mod = 1000000007L;
    }
}
