public class Main {
    public static void main(String[] args) {
        
        

        Scanner sc = new Scanner(System.in);
        String[] string = sc.next().split("");

        
        if(string[0].equals("R")){
            if(string[1].equals("R")){
                if(string[2].equals("R")){
                    System.out.println(3);
                }
            }
        }
        
        if(string[0].equals("R")){
            if(string[1].equals("R")){
                if(string[2].equals("S")){
                    System.out.println(2);
                }
            }
        }
        
        if(string[0].equals("R")){
            if(string[1].equals("S")){
                if(string[2].equals("S")){
                    System.out.println(1);
                }
            }
        }
        
        if(string[0].equals("R")){
            if(string[1].equals("S")){
                if(string[2].equals("R")){
                    System.out.println(1);
                }
            }
        }
        
        if(string[0].equals("S")){
            if(string[1].equals("S")){
                if(string[2].equals("S")){
                    System.out.println(0);
                }
            }
        }
        
        if(string[0].equals("S")){
            if(string[1].equals("S")){
                if(string[2].equals("R")){
                    System.out.println(1);
                }
            }
        }
        
        if(string[0].equals("S")){
            if(string[1].equals("R")){
                if(string[2].equals("R")){
                    System.out.println(2);
                }
            }
        }
        
        if(string[0].equals("S")){
            if(string[1].equals("R")){
                if(string[2].equals("S")){
                    System.out.println(1);
                }
            }
        }


    }
}