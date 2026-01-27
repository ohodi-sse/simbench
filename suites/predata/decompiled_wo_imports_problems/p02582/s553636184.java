public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        if (next.equalsIgnoreCase("SRS") || next.equalsIgnoreCase("SSR") || next.equalsIgnoreCase("RSS") || next.equalsIgnoreCase("RSR")) {
            System.out.println(1);
        }
        else if (!next.contains("R")) {
            System.out.println(0);
        }
        else if (next.equalsIgnoreCase("RRR")) {
            System.out.println(3);
        }
        else {
            System.out.println(2);
        }
    }
}