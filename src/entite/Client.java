package entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="date_naissance", nullable=true, length=30)
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name = "client_compte",

			joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	
	private List<Compte> comptes = new ArrayList<>();

	
	public Client() {
		super();
	}
	
	

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Banque getBanque() {
		return banque;
	}



	public void setBanque(Banque banque) {
		this.banque = banque;
	}



	public List<Compte> getComptes() {
		return comptes;
	}



	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	
	
	

}
