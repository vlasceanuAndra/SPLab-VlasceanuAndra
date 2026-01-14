package org.example.springshop;

import jakarta.persistence.*;

@Entity // Spune Spring-ului ca asta e un tabel in baza de date
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private double pret;

    // Constructor gol (obligatoriu pentru JPA)
    public Product() {}

    // Constructor pentru noi
    public Product(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    // Getters si Setters (necesare ca sa trimitem datele prin JSON)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public double getPret() { return pret; }
    public void setPret(double pret) { this.pret = pret; }
}