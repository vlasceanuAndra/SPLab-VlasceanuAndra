package org.example.springshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    //VIEW(Afisare produse)
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    //ADD (Adaugare produs)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    //EDIT(Modificare produs)
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productNou) {
        return repository.findById(id)
                .map(product -> {
                    product.setNume(productNou.getNume());
                    product.setPret(productNou.getPret());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    productNou.setId(id);
                    return repository.save(productNou);
                });
    }

    //REMOVE (Stergere produs)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}