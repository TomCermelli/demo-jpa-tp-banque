package entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="virement")
public class Virement extends Operation {
	
	@Column(name="beneficiaire")
	private String beneficiaire;
	

	public Virement() {
		super();
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	
}
