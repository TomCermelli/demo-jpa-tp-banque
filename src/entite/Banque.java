package entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class Banque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="id_banque")
	private Set<Client> id_client;

	
	
	public Banque() {
		super();
	}
	
	public Banque(String nom) {
		super();
		this.nom = nom;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Client> getId_client() {
		return id_client;
	}

	public void setId_client(Set<Client> id_client) {
		this.id_client = id_client;
	}
	
}
