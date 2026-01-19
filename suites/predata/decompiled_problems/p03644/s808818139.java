import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Solver
{
    public void run() {
        int i = new Scanner(System.in).nextInt();
        int x = 1;
        for (int n = 0; i > 1; i >>= 1, ++n, x *= 2) {}
        System.out.println(x);
    }
}
// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        new Solver().run();
    }
}
