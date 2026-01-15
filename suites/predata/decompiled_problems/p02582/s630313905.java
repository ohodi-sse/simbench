import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        if (nextLine.equals("SSS")) {
            System.out.print("0");
        }
        else if (nextLine.equals("RRS") || nextLine.equals("SRR")) {
            System.out.print("2");
        }
        else if (nextLine.equals("RRR")) {
            System.out.print("3");
        }
        else {
            System.out.print("1");
        }
    }
}
