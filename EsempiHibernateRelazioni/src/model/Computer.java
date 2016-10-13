package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_computer;
	
	private String modello;
	
	//@ManyToOne
	//private Persona persona;
	
	@ManyToMany
	private Set<Persona> listaPersone =new HashSet<Persona>();
	
	/*public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}*/
	public Computer(){
		this.modello = "";
	}
	public Computer(long id_computer, String modello) {
		this.id_computer = id_computer;
		this.modello = modello;
	}
	public long getId_computer() {
		return id_computer;
	}
	public void setId_computer(long id_computer) {
		this.id_computer = id_computer;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Set<Persona> getListaPersone() {
		return listaPersone;
	}
	public void setListaPersone(Set<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}
	
	public void addPersona(Persona p){
		this.listaPersone.add(p);
	}

}
