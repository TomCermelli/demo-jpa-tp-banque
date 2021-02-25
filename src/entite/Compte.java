package entite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="solde")
	private double solde;
	
	
	@ManyToMany
	@JoinTable(name = "client_compte",

			joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
	
	private List<Client> clients = new ArrayList<>();

	@OneToMany(mappedBy="id_compte")
	private Set<Operation> id_operation = new HashSet<>();
	

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


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public Set<Operation> getId_operation() {
		return id_operation;
	}


	public void setId_operation(Set<Operation> id_operation) {
		this.id_operation = id_operation;
	}


	
	
}
