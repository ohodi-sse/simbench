class Main
{
    final Scanner sc;
    
    Main() {
        this.sc = new Scanner(System.in);
    }
    
    public static void main(final String[] array) {
        new Main().run();
    }
    
    private void run() {
        System.out.println(BigDecimal.valueOf(this.sc.nextLong()).multiply(BigDecimal.valueOf(this.sc.nextDouble())).longValue());
    }
}