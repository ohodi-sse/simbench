public class Main {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		long a = sc.nextLong();
		double b = sc.nextDouble();
		
		
		long result = 0;
		b += 0.001;
		long B = Double.valueOf(b*100).longValue();
		result = (a*B)/100;
		
		
		System.out.println(result);
	}

}