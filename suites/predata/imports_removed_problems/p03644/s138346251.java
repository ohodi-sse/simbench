class Main{



	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);			
		int N = sc.nextInt();
		int ans = 0;
		int numans = 0;

		for(int i = 1;i <= N;i++){
			int sum = counttwo(i);
			ans = Math.max(ans, sum);
			if(sum == ans){
				numans = i;
			}

		}

		System.out.println(numans);


	}

	static int counttwo(int num){					
		int count = 0;
		while(num % 2 == 0){
			count++;
			num /= 2;

		}
		return count;
	}

}