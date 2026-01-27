public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.equals("SSS")) {
            x = 0;
        }
        if (next.equals("SSR")) {
            x = 1;
        }
        if (next.equals("SRS")) {
            x = 1;
        }
        if (next.equals("RSS")) {
            x = 1;
        }
        if (next.equals("RRS")) {
            x = 2;
        }
        if (next.equals("SRR")) {
            x = 2;
        }
        if (next.equals("RSR")) {
            x = 1;
        }
        if (next.equals("RRR")) {
            x = 3;
        }
        System.out.println(x);
    }
}