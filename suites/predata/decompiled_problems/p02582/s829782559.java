import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        switch (next) {
            case "SRR": {
                System.out.println("2");
                break;
            }
            case "RRS": {
                System.out.println("2");
                break;
            }
            case "RRR": {
                System.out.println("3");
                break;
            }
            case "RSR": {
                System.out.println("1");
                break;
            }
            case "SSS": {
                System.out.println("0");
                break;
            }
            case "SSR": {
                System.out.println("1");
                break;
            }
            case "SRS": {
                System.out.println("1");
                break;
            }
            case "RSS": {
                System.out.println("1");
                break;
            }
        }
    }
}
