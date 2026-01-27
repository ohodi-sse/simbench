public class Main {

    int mod ;
    void solve(int v, int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int add = 0;
        while(true){
            if(!set.contains(v-add)){
                System.out.println((v-add));
                return;
            }else if(!set.contains(v+add)){
                System.out.println((v+add));
                return;
            }
            add++;
        }

    }


    public static void main(String[] args)  throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[]  s = br.readLine().split(" ");
        Main test = new Main();

        int n = Integer.parseInt(s[0]);
        int len = Integer.parseInt(s[1]);
        int[] arr = new int[len];
        s = br.readLine().split(" ");
        for(int i=0;i<len;i++) {
           arr[i] = Integer.parseInt(s[i]);

        }

        test.solve(n, arr);
        






















    }

}