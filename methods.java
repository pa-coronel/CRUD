
package crudetxt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class methods {
    
    public static List<Student> student = new ArrayList<Student>();
    
    public static void txtMaker(String filename) throws IOException{
    
        File file = new File(filename);
        file.createNewFile();
    
    }
    
    public static void txtDeleter(String filename){
        
        File file = new File(filename);
        file.delete();
        
    }
    
    public static void txtRenamer(String oldFilename, String newFilename){
        File file = new File(oldFilename);
        file.renameTo(new File(newFilename));
    }
    
    public static boolean txtReader(String filename) throws IOException{
        BufferedReader reader = null;
        boolean checker = false;
        student.clear();
        do{
            try{
                reader = new BufferedReader(new FileReader(filename));

                try{
                    String id, name, address;
                    float math, english, science, average;

                    while((id = reader.readLine()) != null){
                        name = reader.readLine();
                        address = reader.readLine();
                        math = Float.parseFloat(reader.readLine());
                        english = Float.parseFloat(reader.readLine());
                        science = Float.parseFloat(reader.readLine());
                        average = Float.parseFloat(reader.readLine());

                        student.add(new Student(id, name, address, math, english, science, average));
                    }

                }finally{
                    reader.close();
                    checker = false;
                }
            
            }catch(Exception e){
                checker = true;
                txtMaker(filename);
            }
        }while(checker);
            
        return checker;
    }
    
    public static void txtLister(){
        System.out.println("ID number\t Name\t Address\t math\t engliish\t science\t average");
        
        for(Student students: student){
            System.out.print(students.getID() + "\t");
            System.out.print(students.getName() + "\t");
            System.out.print(students.getAddress() + "\t");
            System.out.print(students.getMath() + "\t");
            System.out.print(students.getEnglish() + "\t");
            System.out.print(students.getScience() + "\t");
            System.out.print(students.getAverage() + "\t");
            System.out.println();
        }
        System.out.println("number of student: " + student.size());
    }
    
    public static void txtWriter(String filename){
        PrintWriter writer = null;
        
        try{
            writer = new PrintWriter(new FileWriter(filename));
            
            try{
                for(Student students : student){
                    writer.println(students.getID());
                    writer.println(students.getName());
                    writer.println(students.getAddress());
                    writer.println(students.getMath());
                    writer.println(students.getEnglish());
                    writer.println(students.getScience());
                    writer.println(students.getAverage());
                }
            
            }finally{
                writer.close();
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
