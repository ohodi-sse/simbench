final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final byte nextByte = (scanner = new Scanner(System.in)).nextByte();
        final byte nextByte2;
        if ((nextByte2 = scanner.nextByte()) > 0) {
            final boolean[] array = new boolean[102];
            byte b = 101;
            byte b2 = 0;
            for (byte b3 = 0; b3 < nextByte2; ++b3) {
                final byte nextByte3 = scanner.nextByte();
                if (b > nextByte3) {
                    b = nextByte3;
                }
                if (b2 < nextByte3) {
                    b2 = nextByte3;
                }
                array[nextByte3] = true;
            }
            scanner.close();
            if (b > 0) {
                --b;
            }
            if (b2 <= 100) {
                ++b2;
            }
            int x = 0;
            byte b4 = 101;
            for (byte b5 = b; b5 <= b2; ++b5) {
                if (!array[b5]) {
                    final byte b6 = (byte)Math.abs(nextByte - b5);
                    if (b4 > b6) {
                        b4 = b6;
                        x = b5;
                    }
                }
            }
            System.out.println(x);
            return;
        }
        System.out.println(nextByte);
    }
}