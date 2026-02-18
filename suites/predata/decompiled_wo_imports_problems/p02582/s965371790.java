public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final List<String> list = Arrays.asList(scanner.nextLine().split(""));
        final String[] array = list.toArray(new String[list.size()]);
        for (int i = 0; i < 3; ++i) {
            if (array[i].equals("R")) {
                ++x;
            }
            else if (i == 1 && x == 1) {
                break;
            }
        }
        System.out.println(x);
    }
}