final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final int nextInt = (scanner = new Scanner(System.in)).nextInt();
        final int nextInt2;
        if ((nextInt2 = scanner.nextInt()) == 0) {
            scanner.close();
            System.out.println(nextInt);
            return;
        }
        final ArrayList list = new ArrayList();
        int max = 0;
        for (int i = 0; i < nextInt2; ++i) {
            list.add(scanner.nextInt());
        }
        for (int j = 0; j < nextInt2; ++j) {
            max = Math.max((int)list.get(j), max);
        }
        scanner.close();
        int x = 0;
        int k = 0;
        int min = 101;
        int a = 101;
        while (k < nextInt + max) {
            if (list.contains(k)) {
                ++k;
            }
            else {
                min = Math.min(Math.abs(nextInt - k), min);
                if (Math.min(a, min) == a) {
                    break;
                }
                x = k;
                ++k;
                a = min;
            }
        }
        System.out.println(x);
    }
}