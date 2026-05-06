import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.length() == 3) {
            if (next.equals("RRR")) {
                System.out.println("3");
            }
            else if (next.equals("RRS") || next.equals("SRR")) {
                System.out.println("2");
            }
            else if (next.equals("RSR") || next.equals("SRS") || next.equals("SSR") || next.equals("RSS")) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}
