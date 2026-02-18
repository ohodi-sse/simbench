final class Main
{
    private static void main$3231c38a() {
        int n = 0;
        int x = 0;
        final String nextLine;
        final String[] array = new String[(nextLine = new Scanner(System.in).nextLine()).length()];
        for (int i = 0; i < nextLine.length(); ++i) {
            array[i] = String.valueOf(nextLine.charAt(i));
        }
        for (int j = 0; j < nextLine.length(); ++j) {
            if (array[j].equals("R")) {
                x = ++n;
            }
            else if (array[j].equals("S")) {
                n = 0;
            }
        }
        System.out.println(x);
    }
}