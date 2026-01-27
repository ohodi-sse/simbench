public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        next.split("");
        int x = 0;
        if (next.equals("RRR")) {
            x = 3;
        }
        else if (next.contains("RR")) {
            x = 2;
        }
        else if (next.contains("R")) {
            x = 1;
        }
        System.out.println(x);
    }
}