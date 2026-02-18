public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        int x = 0;
        if (nextLine.equals("RRR")) {
            x = 3;
        }
        if (nextLine.equals("RRS")) {
            x = 2;
        }
        if (nextLine.equals("RSS")) {
            x = 1;
        }
        if (nextLine.equals("SSS")) {
            x = 0;
        }
        if (nextLine.equals("SSR")) {
            x = 1;
        }
        if (nextLine.equals("SRR")) {
            x = 2;
        }
        if (nextLine.equals("SRS")) {
            x = 1;
        }
        if (nextLine.equals("RSR")) {
            x = 1;
        }
        System.out.println(x);
        scanner.close();
    }
}