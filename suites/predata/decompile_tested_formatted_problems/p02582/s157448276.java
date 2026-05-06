import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (!next.equals("SSS")) {
            if (next.equals("SRR") || next.equals("RRS")) {
                x = 2;
            }
            else if (next.equals("RRR")) {
                x = 3;
            }
            else {
                x = 1;
            }
        }
        System.out.println(x);
    }
}
