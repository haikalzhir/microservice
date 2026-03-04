package com.haikal.produk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Ndoro wajib import ini agar @Id tidak merah
import lombok.Data;

@Data
@Entity
public class Produk { // Saya sarankan pakai 'P' besar agar sinkron dengan nama file Produk.java
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tadi kurang huruf 't' pada GenerationType
    private Long id;
    private String nama;
    private String satuan;
    private double harga;
}