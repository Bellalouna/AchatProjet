package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@ExtendWith(MockitoExtension.class)
@Slf4j


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;


    Produit produit = new Produit("2222","telephone", 3);

    List<Produit> listProduits = new ArrayList<Produit>(){
        {
            add(produit);
            add(new Produit("3333", "tablette", 2));
            add(new Produit("4444", "pc", 5));

        }
    };

    @Test
    public void testgetProduit()
    {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit p = produitService.retrieveProduit(1L);
        Assertions.assertNotNull(p);
        log.info("get ===> " + p.toString());
    }
/*
    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }*/


}
