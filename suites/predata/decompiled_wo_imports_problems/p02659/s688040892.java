public final class Main
{
    private static void main$3231c38a() throws IOException {
        final String[] split = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        System.out.println(Long.parseLong(split[0]) * (long)(Double.parseDouble(split[1]) * 100.0 + 0.001) / 100L);
    }
}