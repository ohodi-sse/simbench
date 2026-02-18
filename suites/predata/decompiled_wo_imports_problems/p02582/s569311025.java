public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int x = 0;
        switch (next) {
            case "RSS":
            case "SRS":
            case "SSR":
            case "RSR": {
                x = 1;
                break;
            }
            case "RRS":
            case "SRR": {
                x = 2;
                break;
            }
            case "RRR": {
                x = 3;
                break;
            }
        }
        System.out.println(x);
    }
}