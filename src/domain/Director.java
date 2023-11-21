package domain;

public class Director extends Participant{

    public Director(String name){
        super(name);
    }

    public String toString(){
        return this.getName() + ", director";
    }
    
}