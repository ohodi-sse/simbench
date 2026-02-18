public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        final String next2 = scanner.next();
        scanner.close();
        System.out.println(WeatherMatch(next, next2));
    }
    
    private static int WeatherMatch(String s, String substring) {
        while (s.length() != 0) {
            if (s.charAt(0) == substring.charAt(0)) {
                return 1 + WeatherMatch(s.substring(1), substring.substring(1));
            }
            final String substring2 = s.substring(1);
            substring = substring.substring(1);
            s = substring2;
        }
        return 0;
    }
}