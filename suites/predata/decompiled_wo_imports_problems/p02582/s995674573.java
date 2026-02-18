public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int i = 0;
        switch (next) {
            case "SSR":
            case "SRS":
            case "RSS":
            case "RSR": {
                i = 1;
                break;
            }
            case "SRR":
            case "RRS": {
                i = 2;
                break;
            }
            case "RRR": {
                i = 3;
                break;
            }
        }
        System.out.print(i);
    }
}