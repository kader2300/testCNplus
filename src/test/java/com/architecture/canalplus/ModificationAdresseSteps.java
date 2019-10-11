package com.architecture.canalplus;

import com.architecture.canalplus.dao.IAbonneRepository;
import com.architecture.canalplus.dao.IContratRepository;
import com.architecture.canalplus.model.Abonne;
import com.architecture.canalplus.model.Contrat;
import com.architecture.canalplus.service.IAbonneService;
import com.architecture.canalplus.service.IContratService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class ModificationAdresseSteps extends SpringBootBaseIntegrationTest {
	String newAdresse="newAdresse";
	String oldAdresse="oldAdresse";
	List <Contrat> contrats;
	Abonne abonne;
	@Autowired
	IAbonneRepository abonneRepository;

	@Autowired
	IContratService contratService;
	@Autowired
	IContratRepository contratRepository;
	@Autowired
	IAbonneService abonneService;

//    private final WireMockServer wireMockServer = new WireMockServer();
//    private final CloseableHttpClient httpClient = HttpClients.createDefault();


    @Given("^un abonné avec une adresse principale active en France")
	public void unAbonneAvecUneAdressePrincipaleActiveEnFrance() throws Exception {
		Abonne abonneFACE= new Abonne();
		abonneFACE.setAdresse(oldAdresse);
		abonneFACE.setIdAbonne("FACE");
		abonneFACE.setNom("Contrat abonne FACE");
		abonneRepository.save(abonneFACE);

		Contrat contratTV= new Contrat();
		contratTV.setAdresseAbonne(oldAdresse);
		contratTV.setNomContrat("ContratTV");
		contratTV.setAdresseAbonne(oldAdresse);
		contratTV.setNumero("C1");
		contratTV.setAbonne(abonneFACE);
		contratRepository.save(contratTV);

		Contrat ContratTablette= new Contrat();
		ContratTablette.setAdresseAbonne(oldAdresse);
		ContratTablette.setNomContrat("ContratTablette");
		ContratTablette.setAdresseAbonne(oldAdresse);
		ContratTablette.setNumero("C2");
		ContratTablette.setAbonne(abonneFACE);
		contratRepository.save(ContratTablette);

		Abonne abonneEC= new Abonne();
		abonneEC.setAdresse(oldAdresse);
		abonneEC.setIdAbonne("EC");
		abonneEC.setNom("Contrat abonne abonneEC");
		abonneRepository.save(abonneEC);

		contratTV= new Contrat();
		contratTV.setAdresseAbonne(oldAdresse);
		contratTV.setNomContrat("ContratTV");
		contratTV.setAdresseAbonne(oldAdresse);
		contratTV.setNumero("C3");
		contratTV.setAbonne(abonneEC);
		contratRepository.save(contratTV);

		ContratTablette= new Contrat();
		ContratTablette.setAdresseAbonne(oldAdresse);
		ContratTablette.setNomContrat("ContratTablette");
		ContratTablette.setAdresseAbonne(oldAdresse);
		ContratTablette.setNumero("C4");
		ContratTablette.setAbonne(abonneEC);
		contratRepository.save(ContratTablette);
		Optional<Abonne> abonne = this.abonneRepository.findById("FACE");
		Optional<Abonne> abonneEc = this.abonneRepository.findById("EC");

		assertTrue(abonne.isPresent());
		assertTrue(abonneEc.isPresent());


	}
	@When("^le conseiller connecté à \"([^\"]*)\" modifie l'adresse de l'abonné sans date d'effet$")
	public void leConseillerConnecteModifieAdresse(String canal) throws IOException {
    /*  wireMockServer.start();
        stubFor(put(urlEqualTo("Abonne/ModifierAdresse"))
                .withHeader("content-type", equalTo("APPLICATION_JSON"))
                .willReturn(aResponse().withStatus(200)));

        HttpPut request = new HttpPut("http://localhost:8080/Abonne/ModifierAdresse");
        request.addHeader("content-type","APPLICATION_JSON");
        HttpResponse response = httpClient.execute(request);
        assertEquals(200, response.getStatusLine().getStatusCode());
*/
        abonne= abonneService.ModifierAdresseAbonne(newAdresse,canal);
        Assert.assertEquals(abonne.getAdresse(),newAdresse);
		//wireMockServer.stop();


    }

	@Then("^l'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné")
	public void adresseAbonnéModifiéeEnregistréeSurContratsDeAbonné() throws Exception {
		contratService.modifierAdressDansTousContrat(abonne,newAdresse);
		abonne.getContrats().forEach(contrat -> {
			Assert.assertEquals(contrat.getAdresseAbonne(),newAdresse);
		});

	}

	@And("^un mouvement de modification d'adresse est créé")
	public void mouvementModificationAdresseCréé() throws Exception {
		abonne.getContrats().forEach(contrat -> {
			Assert.assertEquals(contrat.getAdresseAbonne(),newAdresse);
		});	}
	
}
//@kader
