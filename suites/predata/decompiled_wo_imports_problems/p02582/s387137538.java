class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        scanner.close();
        if (next.equals("RRR")) {
            System.out.println("3");
        }
        else if (next.contains("RR")) {
            System.out.println("2");
        }
        else if (next.contains("R")) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}