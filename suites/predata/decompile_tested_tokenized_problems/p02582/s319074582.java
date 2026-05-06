import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS")) {
            x = 2;
        }
        else if (next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSR")) {
            x = 1;
        }
        else if (next.equals("RSS")) {
            x = 1;
        }
        else if (next.equals("SSR")) {
            x = 1;
        }
        else if (next.equals("SRS")) {
            x = 1;
        }
        System.out.println(x);
    }
}
