import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    final Scanner sc;
    
    Main() {
        this.sc = new Scanner(System.in);
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
    
    private void run() {
        final String next = this.sc.next();
        final String next2 = this.sc.next();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) == next2.charAt(i)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
