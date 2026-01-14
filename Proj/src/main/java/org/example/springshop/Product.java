package org.example.springshop;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private double pret;
    public Product() {}
    public Product(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }
}