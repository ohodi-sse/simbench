import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String[] split = new Scanner(System.in).next().split("");
        if (split[0].equals("R") && split[1].equals("R") && split[2].equals("R")) {
            System.out.println(3);
        }
        if (split[0].equals("R") && split[1].equals("R") && split[2].equals("S")) {
            System.out.println(2);
        }
        if (split[0].equals("R") && split[1].equals("S") && split[2].equals("S")) {
            System.out.println(1);
        }
        if (split[0].equals("R") && split[1].equals("S") && split[2].equals("R")) {
            System.out.println(1);
        }
        if (split[0].equals("S") && split[1].equals("S") && split[2].equals("S")) {
            System.out.println(0);
        }
        if (split[0].equals("S") && split[1].equals("S") && split[2].equals("R")) {
            System.out.println(1);
        }
        if (split[0].equals("S") && split[1].equals("R") && split[2].equals("R")) {
            System.out.println(2);
        }
        if (split[0].equals("S") && split[1].equals("R") && split[2].equals("S")) {
            System.out.println(1);
        }
    }
}
