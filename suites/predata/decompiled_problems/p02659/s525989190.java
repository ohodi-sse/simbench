import java.util.Scanner;





public class Main
{
    Scanner sc;
    
    public Main() {
        this.sc = new Scanner(System.in);
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
    
    void run() {
        final long nextLong = this.sc.nextLong();
        final double nextDouble = this.sc.nextDouble();
        long n = 0L;
        for (int i = 0; i < 1000; ++i) {
            if (i / 100.0 == nextDouble) {
                n = i;
            }
        }
        System.out.println(nextLong * n / 100L);
    }
}