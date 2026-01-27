public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		long c = (long)(b * 100.0 + 0.5);
		long res = a * c / 100;
		System.out.println(res);
	}

}