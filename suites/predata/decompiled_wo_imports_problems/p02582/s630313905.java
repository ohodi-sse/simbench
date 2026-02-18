public final class Main
{
    private static void main$3231c38a() {
        final String nextLine;
        if ((nextLine = new Scanner(System.in).nextLine()).equals("SSS")) {
            System.out.print("0");
            return;
        }
        if (nextLine.equals("RRS") || nextLine.equals("SRR")) {
            System.out.print("2");
            return;
        }
        if (nextLine.equals("RRR")) {
            System.out.print("3");
            return;
        }
        System.out.print("1");
    }
}