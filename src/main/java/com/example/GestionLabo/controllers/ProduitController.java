package com.example.GestionLabo.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.GestionLabo.models.Produit;
import com.example.GestionLabo.models.ProduitRequestDto;
import com.example.GestionLabo.serviceImplementaion.ProduitServiceImp;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProduitController {
    private final ProduitServiceImp ProduitServiceImp;
    private final Logger log = LoggerFactory.getLogger(ProduitController.class);

    @PostMapping("")

    public ResponseEntity<Produit> saveProduct(@RequestBody() ProduitRequestDto produit) {
        Produit product = ProduitServiceImp.saveProduct(produit);
        return ResponseEntity.ok(product);
    }

    @GetMapping("")

    public ResponseEntity<List<Produit>> getAllProducts() {
        List<Produit> allproducts = ProduitServiceImp.getAllProducts();
        return ResponseEntity.ok(allproducts);
    }

    @GetMapping("one/{id}")

    public ResponseEntity<Produit> getProductById(String id) {
        Produit produit = ProduitServiceImp.getProductById(id);
        return ResponseEntity.ok(produit);
    }

    @DeleteMapping("{id}")

    public void deleteProduct(   @PathVariable("id") String id) {
        ProduitServiceImp.deleteProduct(id);
    }

    /* @PutMapping("") */
    public Produit modifieProuct(Produit produit) {
        return ProduitServiceImp.modifieProuct(produit);
    }

}
