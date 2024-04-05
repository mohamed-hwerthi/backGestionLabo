package com.example.GestionLabo.serviceDeclaration;

import java.util.List;

import com.example.GestionLabo.models.Produit;
import com.example.GestionLabo.models.ProduitRequestDto;

public interface ProduitServiceDec {
    Produit saveProduct(ProduitRequestDto produit);

    List<Produit> getAllProducts();

    Produit getProductById(String id);

    void deleteProduct(String id);

    Produit modifieProuct(Produit produit);

}
