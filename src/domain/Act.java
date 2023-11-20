package domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Act {
    private int year;
    private String month;
    private int day;
    private ArrayList<Participant> participants;

    public Act(LocalDate l){
        this.year = l.getYear();
        this.month = l.getMonth().toString();
        this.day = l.getDayOfMonth();
    }

    public void addParticipant(Participant p){
        this.participants.add(p);
    }
}