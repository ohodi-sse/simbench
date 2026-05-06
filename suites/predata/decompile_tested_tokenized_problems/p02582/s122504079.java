import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 1;
        final String s = next;
        switch (s) {
            case "RRR": {
                x = 3;
                break;
            }
            case "RRS":
            case "SRR": {
                x = 2;
                break;
            }
            case "SSS": {
                x = 0;
                break;
            }
        }
        System.out.println(x);
    }
}
