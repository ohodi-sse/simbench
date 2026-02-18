final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 1;
        switch (next) {
            case "RRR": {
                x = 3;
                break;
            }
            case "RRS":
            case "SRR": {
                x = 2;
                break;
            }
            case "SSS": {
                x = 0;
                break;
            }
        }
        System.out.println(x);
    }
}