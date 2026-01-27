public class Main
{
    public static PrintWriter out;
    
    public static void main(final String[] array) {
        run();
    }
    
    private static void run() {
        Main.out = new PrintWriter(new BufferedOutputStream(System.out));
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        int x = 1;
        int i = 1;
        int n = 0;
        while (i <= int1) {
            final int countOfDividedByTwo = countOfDividedByTwo(i);
            if (n < countOfDividedByTwo) {
                x = i;
                n = countOfDividedByTwo;
            }
            ++i;
        }
        Main.out.println(x);
        Main.out.close();
        scanner.close();
    }
    
    private static int countOfDividedByTwo(final int n) {
        int n2 = 0;
        for (int n3 = n; n3 % 2 == 0; n3 /= 2, ++n2) {}
        return n2;
    }
}