package com.example.GestionLabo.serviceImplementaion;

import java.util.List;
import java.util.Optional;

import com.example.GestionLabo.models.*;
import com.example.GestionLabo.repository.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.serviceDeclaration.ProduitServiceDec;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduitServiceImp implements ProduitServiceDec {

    private final ProduitRepo produitRepo;
    private final RubriqueRepo rubriqueRepo;
    private final CategorieRepo categorieRepo;
    private final ArmoireRepo armoireRepo ;
    private final ModelMapper modelMapper;
    private  final FournisseurRepo fournisseurRepo ;
    private static final Logger log = LoggerFactory.getLogger(ProduitServiceImp.class);

    @Override
    public Produit saveProduct(ProduitRequestDto produitReqDto) {
        Optional<Categorie>optionalCategorie = this.categorieRepo.findById(produitReqDto.getIdCategorie()) ;
        Categorie categorie = optionalCategorie.orElseThrow(()->new CustomNotFoundException("categorie" ,produitReqDto.getIdCategorie())) ;
        Optional<Fournisseur>optionalFournisseur = this.fournisseurRepo.findById(produitReqDto.getIdFournisseur())  ;
        Fournisseur fournisseur= optionalFournisseur.orElseThrow(()->new CustomNotFoundException("Fournisseur" ,produitReqDto.getIdFournisseur()))  ;
        Optional<Armoire>optionalArmoire= this.armoireRepo.findById(produitReqDto.getIdArmoire()) ;
        Armoire armoire= optionalArmoire.orElseThrow(()->new CustomNotFoundException("Armoire" , produitReqDto.getIdArmoire()));
        Optional<Rubrique>optionalRubrique= this.rubriqueRepo.findById(produitReqDto.getIdRubrique()) ;
        Rubrique rubrique= optionalRubrique.orElseThrow(()->new CustomNotFoundException("Rubrique" ,produitReqDto.getIdRubrique())) ;
        Produit produit = Produit.builder()
                .armoire(armoire)
                .fournisseur(fournisseur)
                .type(produitReqDto.getType())
                .rubrique(rubrique)
                .categorie(categorie)
                .designation(produitReqDto.getDesignation())
                .reference(produitReqDto.getReference())
                .quantiteInitiale(produitReqDto.getQuantiteInitiale())
                .uniteMesure(produitReqDto.getUniteMesure())
                .build();
        Produit savedProduit = this.produitRepo.save(produit);
        categorie.getProduits().add(savedProduit);
        this.categorieRepo.save(categorie);
        rubrique.getProduits().add(savedProduit);
        this.rubriqueRepo.save(rubrique);
        armoire.getProduits().add(savedProduit);
        this.armoireRepo.save(armoire);
        return  savedProduit;

    }

    @Override
    public List<Produit> getAllProducts() {
        return this.produitRepo.findAll();
    }

    @Override
    public Produit getProductById(String id) {
        Optional<Produit> produit = this.produitRepo.findById(id);
        if (produit.isEmpty()) {
            throw new CustomNotFoundException("product", id);

        } else {
            return produit.get();
        }
    }

    @Override
    public void deleteProduct(String id) {
        if (!this.produitRepo.existsById(id)) {
            throw new CustomNotFoundException("product", id);
        }
        this.produitRepo.deleteById(id);
    }

    @Override
    public Produit modifieProuct(Produit produit) {
        throw new RuntimeException("method not yet implemented");
    }

}
