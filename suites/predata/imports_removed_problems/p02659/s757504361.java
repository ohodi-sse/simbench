public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


















        BigDecimal a = sc.nextBigDecimal();
        BigDecimal b = sc.nextBigDecimal();
        BigDecimal ans = a.multiply(b);
        System.out.println(ans.setScale(0,BigDecimal.ROUND_DOWN));
 
        sc.close();
    }
}