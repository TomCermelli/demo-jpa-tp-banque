package entite;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="solde")
	private double solde;
	
	
	@ManyToMany
	@JoinTable(name = "client_compte",

			joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id_client"))
	
	private List<Client> id_client;

	@OneToMany(mappedBy="id_operation")
	private Set<Operation> id_compte;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public List<Client> getId_client() {
		return id_client;
	}


	public void setId_client(List<Client> id_client) {
		this.id_client = id_client;
	}
	
	
}
