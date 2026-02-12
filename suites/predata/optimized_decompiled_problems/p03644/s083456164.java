import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static Scanner s;
    
    private static void main$3231c38a() {
        int nextInt;
        int x;
        for (nextInt = Main.s.nextInt(), x = 1; x << 1 <= nextInt; x <<= 1) {}
        System.out.println(x);
    }
    
    static {
        Main.s = new Scanner(System.in);
    }
}
