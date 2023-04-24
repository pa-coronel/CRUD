
package crudetxt;

import java.io.*;

import static crudetxt.CrudeTXT.input;
import static crudetxt.methods.student;

public class Operations {
    
    static methods m = new methods();
    static validations v = new validations();
    
    static boolean checker = false;
    
    public static void create() throws IOException{
        String id = v.IDInput("Enter ID number: ");
        System.out.print("Enter Name: ");
        String nme = input.readLine();
        System.out.print("Enter Address: ");
        String adrs = input.readLine();

        System.out.println("Enter the grade of the following subjects: ");
        float mth = v.GradesInput("math");
        float eng = v.GradesInput("English");
        float sci = v.GradesInput("Science");

        float ave = ((mth + eng + sci) / 3);

        m.txtReader("students.txt");
        m.student.add(new Student(id, nme, adrs, mth, eng, sci, ave));
        m.txtWriter("students.txt");
    }
    
    public static void read() throws IOException{
        m.txtReader("students.txt");
        
        subReader("Enter ID number you want to open: ");
        
    }
    
    public static void update() throws IOException{
        
        m.txtReader("students.txt");
        
        String StudSelected = subReader("Enter ID number you want to update: ");
        
        m.txtMaker("temp.txt");
        
        PrintWriter writer = null;
        
        try{
            writer = new PrintWriter(new FileWriter("temp.txt"));
            
            try{
                for(Student stud: student){
                    
                    if(StudSelected.equals(stud.getID())){
                        writer.println(stud.getID());
                        
                        int choice = choicer(5);
        
                        switch(choice){
                            case 1:
                                System.out.print("Enter new name: ");
                                String newName = input.readLine();
                                writer.println(newName);
                                writer.println(stud.getAddress());
                                writer.println(stud.getMath());
                                writer.println(stud.getEnglish());
                                writer.println(stud.getScience());
                                writer.println(stud.getAverage());
                                break;

                            case 2:
                                System.out.print("Enter new Address: ");
                                String newAddress = input.readLine();
                                writer.println(stud.getName());
                                writer.println(newAddress);
                                writer.println(stud.getMath());
                                writer.println(stud.getEnglish());
                                writer.println(stud.getScience());
                                writer.println(stud.getAverage());
                                break;

                            case 3:
                                float newMath = v.GradesInput("new grade in math: ");
                                writer.println(stud.getName());
                                writer.println(stud.getAddress());
                                writer.println(newMath);
                                writer.println(stud.getEnglish());
                                writer.println(stud.getScience());
                                writer.println((newMath + stud.getEnglish() + stud.getScience()) / 3);
                                break;

                            case 4:
                                float newEnglish = v.GradesInput("new grade in english: ");
                                writer.println(stud.getName());
                                writer.println(stud.getAddress());
                                writer.println(stud.getMath());
                                writer.println(newEnglish);
                                writer.println(stud.getScience());
                                writer.println((stud.getMath() + newEnglish + stud.getScience()) / 3);
                                break;

                            case 5:
                                float newScience = v.GradesInput("new grade in science: ");
                                writer.println(stud.getName());
                                writer.println(stud.getAddress());
                                writer.println(stud.getMath());
                                writer.println(stud.getEnglish());
                                writer.println(newScience);
                                writer.println((stud.getMath() + stud.getEnglish() + newScience) / 3);
                                break;
                        }
                        
                    }
                    else{
                        writer.println(stud.getID());
                        writer.println(stud.getName());
                        writer.println(stud.getAddress());
                        writer.println(stud.getMath());
                        writer.println(stud.getEnglish());
                        writer.println(stud.getScience());
                        writer.println(stud.getAverage());
                    }
                }
            
            }finally{
                writer.close();
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        m.txtDeleter("students.txt");
        m.txtRenamer("temp.txt", "students.txt");
        
        /*if(checker){
            float newAverage = ()
        }*/
        
        
        
        
        
    }
    
    public static void delete() throws IOException{
        m.txtReader("students.txt");
        
        
        
        String StudSelected = subReader("Enter ID number you want to delete: ");
        
        System.out.println("Delete this record?[y/n]: ");
        char yes = input.readLine().charAt(0);
        
        if(yes == 'y'){

            m.txtMaker("temp.txt");

            PrintWriter writer = null;

            try{
                writer = new PrintWriter(new FileWriter("temp.txt"));

                try{
                    for(Student stud: student){

                        if(StudSelected.equals(stud.getID())){
                            stud.getName();
                            stud.getAddress();
                            stud.getMath();
                            stud.getEnglish();
                            stud.getScience();
                            stud.getAverage();
                        }
                        else{
                            writer.println(stud.getID());
                            writer.println(stud.getName());
                            writer.println(stud.getAddress());
                            writer.println(stud.getMath());
                            writer.println(stud.getEnglish());
                            writer.println(stud.getScience());
                            writer.println(stud.getAverage());
                        }
                    }

                }finally{
                    writer.close();
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            m.txtDeleter("students.txt");
            m.txtRenamer("temp.txt", "students.txt");
        }
        
    }
    
    private static String selecter(String instruction) throws IOException{
        String tempID = "";
        
        do{
            System.out.print(instruction);
            String delete = input.readLine();
            
            for(Student stud: m.student){
                tempID = stud.getID();
                stud.getName();
                stud.getAddress();
                stud.getMath();
                stud.getEnglish();
                stud.getScience();
                stud.getAverage();
                
                if(delete.equals(tempID)){
                    checker = true;
                    break;
                }
                else{
                    checker = false;
                }
            }
            
            if(!checker){
                System.out.println("ID number does not exist");
            }
        }while(!checker);
        
        return tempID;
    }
    
    private static String subReader(String instruction) throws IOException{
        
        System.out.println("ID Number\t Name");
        
        for(Student stud: student){
            System.out.print(stud.getID() + "\t");
            System.out.print(stud.getName());
            stud.getAddress();
            stud.getMath();
            stud.getEnglish();
            stud.getScience();
            stud.getAverage();
            System.out.println();
        }
        
        String IDsearch = selecter(instruction);
        
        for(Student stud: student){
            String tempID = stud.getID();
            if(IDsearch.equals(tempID)){
                System.out.println("ID number[x]: " + tempID);
                System.out.println("     Name[1]: " + stud.getName());
                System.out.println("  Address[2]: " + stud.getAddress());
                System.out.println("     Math[3]: " + stud.getMath());
                System.out.println("  English[4]: " + stud.getEnglish());
                System.out.println("  Science[5]: " + stud.getScience());
                System.out.println("  Average[x]: " + stud.getAverage());
            }
        }
        
        return IDsearch;
    }
    
    public static int choicer(int limit){
        int choice = 0;
        do{
            try{
                checker = false;
                System.out.print("ENTER CHOICE: ");
                choice = Integer.parseInt(input.readLine());
                
                if(choice > limit || choice < 1){
                    System.out.println("invalid input! try again");
                    checker = true;
                }
            }catch(Exception e){
                System.out.println("invalid input! try again");
                checker = true;
            }
        }while(checker);
        
        return choice;
    }
    
}
