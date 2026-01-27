public class Main {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		long a = sc.nextLong();
		String b = sc.next();
		String B = b.replace(".", "");
		
		
		long result = 0;
		result = (a*Long.valueOf(B))/100;
		
		
		System.out.println(result);
	}

}