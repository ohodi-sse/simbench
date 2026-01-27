public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		double b = sc.nextDouble();
		
		BigDecimal bd = new BigDecimal(String.valueOf(a));
		BigDecimal bd1 = new BigDecimal(String.valueOf(b));
		BigDecimal bd2 = bd1.multiply(bd);
		BigDecimal bd3 = bd2.setScale(0, RoundingMode.DOWN);
		
		System.out.println(bd3);
	}

}