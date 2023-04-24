
package crudetxt;

import java.io.*;

public class CrudeTXT {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        
        Operations o = new Operations();
        
        boolean exit = false;
        
        char yes = 'y';
        do{
            System.out.println("STUDENT RECORDS SYSTEM");
            System.out.println("[1] create record");
            System.out.println("[2] display records");
            System.out.println("[3] update record");
            System.out.println("[4] delete record");
            System.out.println("[5] exit");

            int choice = o.choicer(5);

            System.out.println();

            switch(choice){    
                case 1:
                    do{

                        o.create();

                        System.out.print("Create another record?[y/n]:");
                        yes = input.readLine().charAt(0);

                    }while(yes == 'y');
                break;

                case 2:
                    do{

                        o.read();

                        System.out.print("Read another record?[y/n]:");
                        yes = input.readLine().charAt(0);

                    }while(yes == 'y');
                    break;

                case 3:
                    do{

                        o.update();

                        System.out.print("Update another record?[y/n]:");
                        yes = input.readLine().charAt(0);

                    }while(yes == 'y');
                    break;

                case 4:
                    do{

                        o.delete();

                        System.out.print("delete another record?[y/n]:");
                        yes = input.readLine().charAt(0);

                    }while(yes == 'y');
                    break;

                default:

                    System.out.println("thank you :) ");
                    exit = true;

                    break;
            }
            
            if(!exit){
                System.out.print("Go to main menu?[y/n]:");
                yes = input.readLine().charAt(0);
            }
            
        }while(yes == 'y');
    }
    
}
