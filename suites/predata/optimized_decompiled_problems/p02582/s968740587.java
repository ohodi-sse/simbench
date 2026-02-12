import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        int x = 0;
        switch (nextLine) {
            case "RSS": {
                x = 1;
                break;
            }
            case "SRS": {
                x = 1;
                break;
            }
            case "RSR": {
                x = 1;
                break;
            }
            case "SSR": {
                x = 1;
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
                x = 0;
                break;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
