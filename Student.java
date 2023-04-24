
package crudetxt;

public class Student {
    private String id;
    private String name;
    private String address;
    private float math;
    private float english;
    private float science;
    private float average;
    //initializers
    public Student(String id, String name, String address, float math, float english, float science, float average){
        this.id = id;
        this.name = name;
        this.address = address;
        this.math = math;
        this.english = english;
        this.science = science;
        this.average = average;
    }
    //getters
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public float getMath(){
        return math;
    }
    public float getEnglish(){
        return english;
    }
    public float getScience(){
        return science;
    }
    public float getAverage(){
        return average;
    }
    //setters
    public void setID(String id) {
	this.id = id;
    }
    public void setName(String name) {
	this.name = name;
    }
    public void setAddress(String address) {
	this.address = address;
    }
    public void setMath(float math) {
	this.math = math;
    }
    public void setEnglish(float english) {
	this.english = english;
    }
    public void setScience(float science) {
	this.science = science;
    }
    public void setAverage(float average) {
	this.average = average;
    }
    
    
}
