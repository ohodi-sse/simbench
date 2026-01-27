public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x;
        if (next.indexOf("RRR") != -1) {
            x = 3;
        }
        else if (next.indexOf("RR") != -1) {
            x = 2;
        }
        else if (next.indexOf(82) != -1) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}