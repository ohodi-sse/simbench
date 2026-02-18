public final class Main
{
    private static void main$3231c38a() {
        final String[] split = new Scanner(System.in).next().split("S");
        int max = 0;
        for (int i = 0; i < split.length; ++i) {
            max = Math.max(max, split[i].length());
        }
        System.out.println(max);
    }
}