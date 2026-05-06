import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        switch (next) {
            case "SSS": {
                x = 0;
                break;
            }
            case "SRR": {
                x = 2;
                break;
            }
            case "RRS": {
                x = 2;
                break;
            }
            case "RRR": {
                x = 3;
                break;
            }
            default: {
                x = 1;
                break;
            }
        }
        System.out.println(x);
    }
}
