public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		double a=sc.nextDouble();
		double b=sc.nextDouble();
		
		BigDecimal a1 = new BigDecimal(String.valueOf(a));	
		BigDecimal b1 = new BigDecimal(String.valueOf(b));
		
		BigDecimal c= a1.multiply(b1);		
		BigDecimal value =c.setScale(0, RoundingMode.DOWN);	
		
		long l = value.longValueExact();	
		
		System.out.println(l);	
	}

}