class Main
{
    public static void main(final String[] array) {
        final String nextLine = new Scanner(System.in).nextLine();
        int i = 0;
        final int index = 0;
        if (nextLine.charAt(index) == 'R') {
            ++i;
            if (nextLine.charAt(index + 1) == 'R') {
                ++i;
                if (nextLine.charAt(index + 2) == 'R') {
                    ++i;
                }
            }
        }
        else if (nextLine.charAt(index + 1) == 'R') {
            ++i;
            if (nextLine.charAt(index + 2) == 'R') {
                ++i;
            }
        }
        else if (nextLine.charAt(index + 2) == 'R') {
            ++i;
        }
        System.out.print(i);
    }
}