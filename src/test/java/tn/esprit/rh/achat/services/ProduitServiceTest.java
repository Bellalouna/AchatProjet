package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

    
    @Autowired
    private ProduitRepository produitRepository;
    
    @Mock
    private IProduitService ps;    

    @Test
    @Order(1)
	public void testRetrieveAllProduits() {
		List<Produit> listProduits = ps.retrieveAllProduits();
		Assertions.assertEquals(0, listProduits.size());
	}


    @Order(2)
    @Test
    public void testAddProduit() {
        Produit expected = new Produit();
        Produit result = ps.addProduit(expected);
        Assertions.assertEquals(expected, result);
    }
    
    
    @Order(3)
    @Test
    public void testUpdateProduit() {
        Produit p = new Produit();
        Produit updatedProduit = ps.updateProduit(p);
        Assertions.assertEquals(p, updatedProduit);
    }
    
    
    @Order(4)
    @Test
    public void testRetrieveProduit() {
        Produit produit = new Produit();
        produit.setLibelleProduit("libelleProduit");
        produitRepository.save(produit);
        Produit produitRetourne = ps.retrieveProduit(produit.getIdProduit());
        Assertions.assertEquals(produit, produitRetourne);
    }

    
    
    
    @Order(5)
    @Test
    public void testAssignProduitToStock() {
        Long idProduit = 1L;
        Long idStock = 2L;
        ps.assignProduitToStock(idProduit, idStock);
        Produit produit = produitRepository.findById(idProduit).get();
        Assertions.assertEquals(produit.getStock().getIdStock(), idStock);
    }


    
    @Order(6)
    @Test
    public void testDeleteProduit() {
    Long produitId = 44L;
    ps.deleteProduit(produitId);
    Optional<Produit> produit = produitRepository.findById(produitId);
    Assertions.assertTrue(produit.isPresent());
    }



}
