package domain;

import java.util.ArrayList;

public class MusicBand extends Participant{

    ArrayList<Participant> participants;
    ArrayList<Act> acts;

    public MusicBand(String name){
        super(name);
        this.participants = new ArrayList<>();
        this.acts = new ArrayList<>();
    }

    public void addAct(Act a){
        this.acts.add(a);
    }

    public void addParticipant(Participant p){
        this.participants.add(p);
    }
    

}