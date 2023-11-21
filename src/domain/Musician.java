package domain;

public class Musician extends Participant{

    private String instrument;

    public Musician(String name, String intrument){
        super(name);
        this.instrument = intrument;
    }

    public String getInstrument(){
        return this.instrument;
    }
}