package app;
import interfaze.Interface;

public class Main{
    private static Interface i = new Interface();
    public static void main(String[] args){
        String input = i.getInput("Que desea hacer?");
        int x  = i.chooseMethod(input);

        System.out.println("Input: " + input);
        System.out.println("Returns "+ x);
        if(x == 0){
            Main.main(args);
        }
        else if(x == -1){
            ;
        }
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
