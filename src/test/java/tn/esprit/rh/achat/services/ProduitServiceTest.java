package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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

    /*@Test
    @Order(1)
    public void testRetrieveAllProduits() {
        List<Produit> expected = Arrays.asList(
            new Produit("p1", 1),
            new Produit("p2", 2)
        );

        when(ps.retrieveAllProduits()).thenReturn(expected);
        List<Produit> actual = ps.retrieveAllProduits();
        Assertions.assertEquals(expected, actual);
    }*/


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
    public void testretrieveProduit() {
        Long produitId = 2L;
        Produit produit = ps.retrieveProduit(produitId);
        Assertions.assertNotNull(produit);
    }
    
    
    
    @Order(5)
    @Test
    public void testAssignProduitToStock() {
        Long idProduit = 4L;
        Long idStock = 1L;
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
    Assertions.assertFalse(produit.isPresent());
    }



}
