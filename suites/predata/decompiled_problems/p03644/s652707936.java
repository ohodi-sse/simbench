import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        int int1;
        int x;
        for (int1 = Integer.parseInt(new Scanner(System.in).nextLine()), x = 1; x * 2 <= int1; x *= 2) {}
        System.out.println(x);
    }
}
