import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        System.out.println(solve(new Scanner(System.in).next()));
    }
    
    static int solve(final String s) {
        if (s.contains("RRR")) {
            return 3;
        }
        if (s.contains("RR")) {
            return 2;
        }
        if (s.contains("R")) {
            return 1;
        }
        return 0;
    }
}
