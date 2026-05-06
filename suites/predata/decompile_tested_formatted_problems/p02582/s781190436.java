import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    static Scanner sc;
    
    public static void main(final String[] array) {
        final String next = Main.sc.next();
        if (next.equals("RRR")) {
            System.out.println(3);
        }
        else if (next.equals("RSR") || next.equals("RSS") || next.equals("SSR") || next.equals("SRS")) {
            System.out.println(1);
        }
        else if (next.equals("SSS")) {
            System.out.println(0);
        }
        else {
            System.out.println(2);
        }
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
