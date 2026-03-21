import java.util.Scanner;





public class Main
{
    public void solve() {
        final String next = new Scanner(System.in).next();
        if (next.equals("SSS")) {
            System.out.println(0);
        }
        if (next.equals("SSR")) {
            System.out.println(1);
        }
        if (next.equals("SRS")) {
            System.out.println(1);
        }
        if (next.equals("RSS")) {
            System.out.println(1);
        }
        if (next.equals("RRS")) {
            System.out.println(2);
        }
        if (next.equals("RSR")) {
            System.out.println(1);
        }
        if (next.equals("SRR")) {
            System.out.println(2);
        }
        if (next.equals("RRR")) {
            System.out.println(3);
        }
    }
    
    public static void main(final String[] array) {
        new Main().solve();
    }
}