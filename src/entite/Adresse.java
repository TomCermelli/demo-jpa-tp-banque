package entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Embeddable
public class Adresse {
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="rue")
	private String rue;
	
	@Column(name="code_postal")
	private int codePostal;
	
	@Column(name="ville")
	private String ville;
	
	
	public Adresse() {
		super();
	}
	
	
	
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}
