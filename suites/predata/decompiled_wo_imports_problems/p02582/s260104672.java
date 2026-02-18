final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String nextLine;
            int x;
            if ((nextLine = scanner.nextLine()).equalsIgnoreCase("ssr") || nextLine.equalsIgnoreCase("srs") || nextLine.equalsIgnoreCase("rss") || nextLine.equalsIgnoreCase("rsr")) {
                x = 1;
            }
            else if (nextLine.equalsIgnoreCase("rrs") || nextLine.equalsIgnoreCase("srr")) {
                x = 2;
            }
            else if (nextLine.equalsIgnoreCase("rrr")) {
                x = 3;
            }
            else {
                x = 0;
            }
            System.out.println(x);
        }
    }
}