public final class Main
{
    private static Scanner scanner;
    
    private static void main$3231c38a() {
        final String value;
        if ((value = String.valueOf(Long.parseLong((Main.scanner = new Scanner(System.in)).next()) * Math.round(Double.parseDouble(Main.scanner.next()) * 100.0))).length() <= 2) {
            System.out.print("0");
            return;
        }
        for (int i = 0; i < value.length() - 2; ++i) {
            System.out.print(value.charAt(i));
        }
    }
    
    private static String gs() {
        return Main.scanner.next();
    }
    
    private static int gi() {
        return Integer.parseInt(Main.scanner.next());
    }
    
    private static long gl() {
        return Long.parseLong(Main.scanner.next());
    }
    
    private static double gd() {
        return Double.parseDouble(Main.scanner.next());
    }
}