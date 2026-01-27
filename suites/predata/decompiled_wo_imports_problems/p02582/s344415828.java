public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.equals("RRS") || next.equals("SRR")) {
            x = 2;
        }
        else if (next.equals("RSS") || next.equals("RSR") || next.equals("SRS") || next.equals("SSR")) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}