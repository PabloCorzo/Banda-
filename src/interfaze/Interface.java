package interfaze;

import domain.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;


public class Interface implements Serializable{

	private ArrayList<MusicBand>bands;
	private static Scanner sc = new Scanner(System.in);
	public Interface(){
	ObjectInputStream obj;
	File file = new File("musicband.txt");
	try{
	obj = new ObjectInputStream(new FileInputStream(file));
	try{bands = (ArrayList<MusicBand>)obj.readObject();}catch(Exception e){System.out.println("No leido: " + e);}
	
	obj.close();
	System.out.println("Leido");
	}catch(Exception e){
	System.out.println("No leido.");
	bands = new ArrayList<>();
	}
	}
	public void help(){
	System.out.println("Que desea hacer?");
	System.out.println("\"Help\" para ayuda");
	System.out.println("\"Mostrar\" para mostrar");
	System.out.println("\"Agregar acto\" para agregar un acto");
	System.out.println("\"Agregar participante\" para Agregar un participante (a un acto)");
	System.out.println("\"Salir\" para salir");
	}

	public void save(){
	ObjectOutputStream obj;
	File file = new File("musicband.txt");
	try{
	obj = new ObjectOutputStream(new FileOutputStream(file));
	obj.writeObject(this.bands);
	obj.close();
	sc.close();
	System.out.println("Guardado");
	}catch(Exception e){
	System.out.println("Error al guardar. \n " + e);
	}
	}
	
	public void show(){
	String s = "";
	for(MusicBand mb: this.bands){
	s += mb.toString() + "\n";
	}
	System.out.println(s);
	}

	public void addAct(String input){
		String[] split = input.split(" ");
		String band = split[0];
		int day = Integer.parseInt(split[1]);
		int month = Integer.parseInt(split[2]);
		int year = Integer.parseInt(split[3]);
		Act a = new Act(LocalDate.of(year,month, day));
		if(this.bandExists(band)){
			this.bands.get(this.getBandIndex(band)).addAct(a);
		}
		else{
			System.out.println("La banda no existe.");
		}
	}

	public void addDirector(String input){
		String[] split = input.split(" ");
		String band = split[0];
		String name = split[1];
		Director d = new Director(name);
		if(this.bandExists(band)){
			this.bands.get(this.getBandIndex(band)).addParticipant(d);
		}
		else{
			System.out.println("La banda no existe.");
		}
	}

	public void addMusicPartner(String input){
		String[] split = input.split(" ");
		String band = split[0];
		String name = split[1];
		String instrument = split[2];
		int id = Integer.parseInt(split[3]);
		MusicPartner mp = new MusicPartner(name, instrument, id);
		if(this.bandExists(band)){
			this.bands.get(this.getBandIndex(band)).addParticipant(mp);
		}
		else{
			System.out.println("La banda no existe.");
		}
	}

	public void addMusicSupport(String input){
		String[] split = input.split(" ");
		String band = split[0];
		String name = split[1];
		String instrument = split[2];
		BigDecimal pay = new BigDecimal(split[3]);
		MusicSupport ms = new MusicSupport(name, instrument, pay);
		if(this.bandExists(band)){
			this.bands.get(this.getBandIndex(band)).addParticipant(ms);
		}
		else{
			System.out.println("La banda no existe.");
		}
	}
	
	public boolean bandExists(String mb){
		boolean exists = false;
	for(MusicBand b : this.bands){
		if(b.getName().equalsIgnoreCase(mb)){
			exists = true;
		}
	}
	return exists;
}

	public int getBandIndex(String mb){
		for(MusicBand b : this.bands){
			if(b.getName().equalsIgnoreCase(mb)){
				return this.bands.indexOf(b);
			}
		}
		return -1;
	}

	public String getInput(String prompt){
	System.out.println(prompt);	
	String input = sc.nextLine();
	return input;
	}

	public void chooseMethod(String input){
	String[] split = input.split(" ");
	if(split[0].equalsIgnoreCase("Help")){
	this.help();
	}
	else if(split[0].equalsIgnoreCase("Mostrar")){
	this.show();
	}
	else if(split[0].equalsIgnoreCase("Agregar") && split[1].equalsIgnoreCase("acto")){
		this.addAct(this.getInput("Introduzca: nombre de la banda, dia, mes y año"));
	}
	else if(split[0].equalsIgnoreCase("Agregar") && split[1].equalsIgnoreCase("participante")){
		String type = this.getInput("Director, socio o apoyo?");
		if(type.equalsIgnoreCase("Director")){
			this.addDirector(this.getInput("Introduzca: banda y nombre"));
		}
		else if(type.equalsIgnoreCase("Socio")){
			this.addMusicPartner(this.getInput("Introduzca: banda, nombre, instrumento y codigo de id"));
		}
		else if(type.equalsIgnoreCase("Apoyo")){
			this.addMusicSupport(this.getInput("Introduzca: banda, nombre, instrumento y paga"));
		}
	}
	}
}
