package entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {
	
	@Id
	private int id;
	
	@Column(name="solde")
	private LocalDateTime date;
	
	@Column(name="solde")
	private double montant;
	
	@Column(name="solde")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="id_operation")
	private Compte id_compte;

	
	public Operation() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getId_compte() {
		return id_compte;
	}

	public void setId_compte(Compte id_compte) {
		this.id_compte = id_compte;
	}
	
	
	
	
	
	
}
