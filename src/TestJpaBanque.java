import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entite.Adresse;
import entite.AssuranceVie;
import entite.Banque;
import entite.Client;
import entite.Compte;
import entite.LivretA;
import entite.Operation;
import entite.Virement;

public class TestJpaBanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo_jpa_banque");
		EntityManager em = factory.createEntityManager();
		
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
		// BANQUE

		Banque banque1 = new Banque("BNP Paribas");
		Banque banque2 = new Banque("Crédit Agricole");
		em.persist(banque1);
		em.persist(banque2);
		 
		// Adresse
		Adresse adresse1= new Adresse(26, "Rue de Clementville", 34070, "Montpellier");
		Adresse adresse2 = new Adresse(8, "Rue du Bayle", 34000, "Montpellier");
		
		
		
		// Client
		Client client1 = new Client();
		client1.setNom("CERMELLI");
		client1.setPrenom("Tom");
		client1.setDateNaissance(LocalDate.of(1997, 5, 14));
		client1.setAdresse(adresse1);
		client1.setBanque(banque1);
		em.persist(client1);
		
		Client client2 = new Client();
		client2.setNom("CHARBONNIER");
		client2.setPrenom("Guillaume");
		client2.setDateNaissance(LocalDate.of(1995, 11, 25));
		client2.setAdresse(adresse1);
		client2.setBanque(banque2);
		em.persist(client2);
		
		Client client3 = new Client();
		client3.setNom("Test");
		client3.setPrenom("Client3");
		client3.setDateNaissance(LocalDate.of(1995, 7, 31));
		client3.setAdresse(adresse1);
		client3.setBanque(banque2);
		em.persist(client3);
		
		// Compte
		
		Compte compte1 = new Compte();
		compte1.setNumero("FR56512514546");
		compte1.setSolde(1450d);
		em.persist(compte1);
		
		Compte compte2 = new Compte();
		compte2.setNumero("FR565454614546");
		compte2.setSolde(850d);
		em.persist(compte2);
		
		// Assurance Vie / Livret A
		AssuranceVie assuranceVie = new AssuranceVie();
		assuranceVie.setNumero("FR56512514546");
		assuranceVie.setSolde(1450d);
		assuranceVie.setDateFin(LocalDate.of(2022, 6, 25));
		assuranceVie.setTaux(12.5);
		em.persist(assuranceVie);
		
		LivretA livretA = new LivretA();
		livretA.setNumero("FR56512514546");
		livretA.setSolde(1450d);
		livretA.setTaux(12.5);
		em.persist(livretA);
		
		// Virement
		
		Virement virement = new Virement();
		virement.setDate(LocalDateTime.now());
		virement.setMontant(500);
		virement.setMotif("Cadeaux de Noel");
		virement.setId_compte(compte2);
		virement.setBeneficiaire(client3.getNom());
		em.persist(virement);
		
		Virement virement2 = new Virement();
		virement2.setDate(LocalDateTime.now());
		virement2.setMontant(250);
		virement2.setMotif("Loyer");
		virement2.setId_compte(compte1);
		virement2.setBeneficiaire(client2.getNom());
		em.persist(virement2);
		
		// Operation
		
		Operation operation = new Operation();
		operation.setDate(LocalDateTime.now());
		operation.setMontant(450);
		operation.setMotif("Epargne");
		operation.setId_compte(compte1);
		em.persist(operation);
		
		Operation operation2 = new Operation();
		operation2.setDate(LocalDateTime.now());
		operation2.setMontant(500);
		operation2.setMotif("Nouveau pc");
		operation2.setId_compte(assuranceVie);
		em.persist(operation2);

		
		// Ajout de client au compte ( dans la table jointure ) 
		compte1.getClients().add(client1);
		compte1.getClients().add(client2);
		
		
		// Meme mécanique qu'avant mais à partir de client avec des compte livret A et Assurance Vie
		client3.getComptes().add(compte2);
		client3.getComptes().add(assuranceVie);
		client3.getComptes().add(livretA);
		
		tr.commit();
		//compte1
		
	}

}
