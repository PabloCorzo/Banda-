package domain;

import java.math.BigDecimal;

public class MusicSupport extends Musician{

    private BigDecimal pay; 

    public MusicSupport(String name, String instrument, BigDecimal b){
        super(name,instrument);
        this.pay = b;
    }
    public String toString(){
        return this.getName()+", "+ this.getInstrument()+", " + this.pay +" €";
    }
}