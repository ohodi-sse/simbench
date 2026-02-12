import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).nextLine().split("");
        final String anObject = "R";
        int x;
        if (split[0].equals(anObject)) {
            x = 1;
        }
        else {
            x = 0;
        }
        if (split[1].equals(anObject)) {
            ++x;
        }
        if (split[2].equals(anObject)) {
            ++x;
        }
        if (x == 1 || x == 3 || x == 0) {
            System.out.println(x);
            return;
        }
        if (x == 2 && split[0].equals(anObject) && split[2].equals(anObject)) {
            System.out.println(1);
            return;
        }
        System.out.println(2);
    }
}
