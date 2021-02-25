package entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operation")
@Inheritance(strategy=InheritanceType.JOINED)
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="montant")
	private double montant;
	
	@Column(name="motif")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="id_compte")
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
