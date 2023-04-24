
package crudetxt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class validations {
    
    public static List<Student> student = new ArrayList<Student>();
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static boolean checker = false;
    
    static methods m = new methods();
    
    public static float GradesInput(String subject) throws IOException{
        float grade = 0;
        
        do{//grades input
            try{
                System.out.print(subject+": ");
                grade = Float.parseFloat(input.readLine());
                checker = false;
            }catch(Exception e){
                checker = true;
                System.out.println("Invalid input! please try again");
            }
            if(grade > 100){
                checker = true;
                System.out.println("Its over 100! pleas try again");
            }
        }while(checker);
        
        return grade;
    }
    
    public static String IDInput(String instruction) throws IOException{
        String ID = "";
        
        do{//ID number
            checker = false;
            System.out.print(instruction);
            ID = input.readLine();
            int dashCounter = 0;
            
            for(int x = 0; x < ID.length(); x++){
                
                if(ID.charAt(x) == '-'){
                    dashCounter++;
                    if(dashCounter >= 2){
                        System.out.println("invalid id number!");
                        checker = true;
                        break;
                    }
                }
                
                if((!Character.isDigit(ID.charAt(x)) && ID.charAt(x) != '-') || (ID.startsWith("-") || (ID.endsWith("-")))){
                    System.out.println("invalid id number!");
                    checker = true;
                    break;
                }
            }
            
            checker = m.txtReader("students.txt");
            
            if(!checker){
                checker = false;
                for(Student stud: m.student){
                    String temp = stud.getID();
                    stud.getName();
                    stud.getAddress();
                    stud.getMath();
                    stud.getEnglish();
                    stud.getScience();
                    stud.getAverage();
                    if(temp.equals(ID)){
                        System.out.println("ID number already exist! try another one");
                        checker = true;
                        break;
                    }
                }
            }
            
            
        }while(checker);
        
        return ID;
    }
    
}
