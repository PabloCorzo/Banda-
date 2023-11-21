package domain;

public class MusicPartner extends Musician{
    
    private String instrument;
    private int id;

    public MusicPartner(String name, String instrument, int id){
        super(name,instrument);
        this.id = id;
    }

    public String toString(){
        return this.getName()+", " + this.instrument+", numero de socio: " + this.id;
    }
}