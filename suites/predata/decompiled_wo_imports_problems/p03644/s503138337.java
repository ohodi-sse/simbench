final class Main
{
    private static void main$3231c38a() {
        Scanner scanner;
        int nextInt;
        int x;
        for (nextInt = (scanner = new Scanner(System.in)).nextInt(), x = 1; x << 1 <= nextInt; x <<= 1) {}
        System.out.println(x);
        scanner.close();
    }
}