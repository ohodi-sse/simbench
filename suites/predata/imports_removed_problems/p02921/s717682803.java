public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);





		String S = scanner.next();

		String K = scanner.next();

		int ans=0;

		if(S.substring(0, 1).equals(K.substring(0, 1))) {
			ans++;
		}

		if(S.substring(1, 2).equals(K.substring(1, 2))) {
			ans++;
		}

		if(S.substring(2, 3).equals(K.substring(2, 3))) {
			ans++;
		}

		log(ans);





























	}


	/**
	 * バブルソートの交換数を算出
	 * ※転倒数
	 * @param array
	 * @return
	 */
	private static int countSwapBabbleSort(int[] array) {
		int ans = 0;
		int[] binary = new int[array.length + 1];

		for (int index = 0; index < array.length; index++) {
			ans = ans + (index - sum(binary, array[index]));
			add(binary, array[index], 1);
		}
		return ans;
	}

    
	private static void add(int[] bit,int idx,int value) {
        for(int i=idx;i<bit.length;i=i+(i&-i)) {
        	bit[i] += value;
        }
    }

    
	private static int sum(int[] bit,int idx) {
        int ret = 0;
        for(int i=idx;i>0;i-=(i&-i)) {
        	ret += bit[i];
        }
        return ret;
    }

	private static void log(String str) {
		System.out.println(str);
	}

	private static void log(int str) {
		System.out.println(str);
	}

	private static void log(double str) {
		System.out.println(str);
	}

}