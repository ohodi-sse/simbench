import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        String x = "0";
        if (nextLine.indexOf("RRR") >= 0) {
            x = "3";
        }
        else if (nextLine.indexOf("RR") >= 0) {
            x = "2";
        }
        else if (nextLine.indexOf("R") >= 0) {
            x = "1";
        }
        System.out.println(x);
    }
}
