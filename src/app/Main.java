package app;
import java.math.BigDecimal;
import java.time.LocalDate;
import domain.*;
public class Main{
    public static void main(String[] args){
        MusicBand mb = new MusicBand("Banda de Música de Villar del Monte");
        Act act1 = new Act(LocalDate.of(2019, 11, 25));
        mb.addAct(act1);
        Director dir = new Director("José García López");
        act1.addParticipant(dir);
        MusicPartner mscpart = new MusicPartner("Antonio López Suárez", "clarinete", 28534);
        act1.addParticipant(mscpart);
        MusicSupport mscsupp1 = new MusicSupport("Juan Jaén Bernal", "tuba", new BigDecimal(121));
        act1.addParticipant(mscsupp1);
        Act act2 = new Act(LocalDate.of(2019, 12, 16));
        mb.addAct(act2);
        MusicSupport mscsupp2 = new MusicSupport("María López Gil", "oboe", new BigDecimal(130));
        act2.addParticipant(dir);
        act2.addParticipant(mscpart);
        act2.addParticipant(mscsupp2);
        System.out.println(mb);
    }
}

// BANDA DE MÚSICA DE VILLAR DEL MONTE
// Fecha de actuación: 25-11-2019
// José García López, director
// Antonio López Suárez, clarinete, clarinete, número de socio: 28534
// Juan Jaén Bernal, tuba, 121,00 C
// Fecha de actuación: 16-12-2019
// José García López, director
// Antonio López Suárez, clarinete, clarinete, número de socio: 28534
// María López Gil, oboe, 130,00 C
