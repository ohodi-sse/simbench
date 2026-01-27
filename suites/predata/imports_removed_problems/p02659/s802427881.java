public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		
		BigDecimal a = new BigDecimal(sc.nextBigInteger()).multiply(sc.nextBigDecimal());
        System.out.println(a.setScale(0, BigDecimal.ROUND_DOWN));
	}
}