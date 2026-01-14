package org.example.springshop;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Asta e un DESIGN PATTERN: Repository Pattern
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Nu trebuie sa scrii nimic aici. Spring face totul magic.
}
