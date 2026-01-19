import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Solver
{
    public void run() {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String[] split = scanner.next().split("\\.");
        System.out.println(nextLong * (Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1])) / 100L);
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
