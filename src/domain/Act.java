package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Act {
    private int year;
    private int month;
    private int day;
    private ArrayList<Participant> participants;

    public Act(LocalDate l){
        this.participants = new ArrayList<>();
        this.year = l.getYear();
        this.month = l.getMonthValue();
        this.day = l.getDayOfMonth();
    }

    public void addParticipant(Participant p){
        this.participants.add(p);
    }

    public ArrayList<Participant> getParticipants(){
        return this.participants;
    }

    public String toString(){
        String tochaco =  "Fecha de actuacion: "+this.day+"-"+this.month+"-"+this.year;
        for(Participant p : this.participants){
            tochaco += "\n";
            tochaco += p.toString();
        }
        return tochaco;
    }
}