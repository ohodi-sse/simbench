public class Main {

    public static void main(String[] args) {
	


        Scanner scan = new Scanner(System.in);
        BigDecimal N= scan.nextBigDecimal();
        BigDecimal M= scan.nextBigDecimal();
        BigDecimal b3 = N.multiply(M);
BigDecimal p = b3.setScale(0, BigDecimal.ROUND_DOWN);;
        System.out.println(p);
 


    }
}