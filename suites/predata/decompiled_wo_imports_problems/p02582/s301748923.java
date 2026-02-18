public final class Main
{
    private static void main$3231c38a() {
        final String[] split;
        if (!(split = new Scanner(System.in).next().split(""))[0].equals("R") && !split[1].equals("R") && !split[2].equals("R")) {
            System.out.println(0);
            return;
        }
        if (split[0].equals("R") && split[1].equals("R") && split[2].equals("R")) {
            System.out.println(3);
            return;
        }
        if (split[0].equals("R") && split[1].equals("R")) {
            System.out.println(2);
            return;
        }
        if (split[1].equals("R") && split[2].equals("R")) {
            System.out.println(2);
            return;
        }
        if (split[0].equals("R")) {
            System.out.println(1);
            return;
        }
        if (split[1].equals("R")) {
            System.out.println(1);
            return;
        }
        if (split[2].equals("R")) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}