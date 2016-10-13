package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_persona;
	
	private String nome;
	private String cognome;
	
	//@OneToOne
	//private Computer computer;
	
	@ManyToMany(mappedBy="listaPersone")
	private Set<Computer> listaComputer = new HashSet<Computer>();
	
	
	public Persona(){
		this.nome = "";
		this.cognome = "";
	}
	
	public Persona(int id_persona, String nome, String cognome) {
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/*public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}*/

	public Set<Computer> getListaComputer() {
		return listaComputer;
	}

	public void setListaComputer(Set<Computer> listaComputer) {
		this.listaComputer = listaComputer;
	}
	
	public void addComputer(Computer c){
		this.listaComputer.add(c);
	}
	
}
