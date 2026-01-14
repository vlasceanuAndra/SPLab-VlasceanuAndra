package org.example.springshop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Spune ca aceasta clasa raspunde la cereri WEB
@RequestMapping("/api/products") // Toate linkurile incep cu /api/products
public class ProductController {

    @Autowired // Injecteaza automat Repository-ul (Dependency Injection)
    private ProductRepository repository;

    // 1. VIEW (GET) - Vedem toate produsele
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // 2. ADD (POST) - Adaugam un produs
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // 3. EDIT (PUT) - Modificam un produs
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

    // 4. REMOVE (DELETE) - Stergem un produs
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}