import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final String next = new Scanner(System.in).next();
        if (next.equals("RRR")) {
            System.out.println(3);
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            System.out.println(2);
        }
        else if (next.equals("SSS")) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }
    }
}
