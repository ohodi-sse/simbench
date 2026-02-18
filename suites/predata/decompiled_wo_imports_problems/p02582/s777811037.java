public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        final char[] array = new char[3];
        for (int i = 0; i < 3; ++i) {
            array[i] = nextLine.charAt(i);
        }
        if (array[0] == 'R') {
            ++x;
            if (array[1] == 'R') {
                ++x;
                if (array[2] == 'R') {
                    ++x;
                }
            }
        }
        else if (array[1] == 'R') {
            ++x;
            if (array[2] == 'R') {
                ++x;
            }
        }
        else if (array[2] == 'R') {
            ++x;
        }
        System.out.println(x);
    }
}