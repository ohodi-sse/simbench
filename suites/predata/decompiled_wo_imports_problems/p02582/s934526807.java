public final class Main
{
    private static void main$3231c38a() {
        final String nextLine;
        int x;
        if ((nextLine = new Scanner(System.in).nextLine()).equals("RRR")) {
            x = 3;
        }
        else if (nextLine.indexOf("R") == -1) {
            x = 0;
        }
        else if (nextLine.indexOf("RR") == -1) {
            x = 1;
        }
        else {
            x = 2;
        }
        System.out.println(x);
    }
}