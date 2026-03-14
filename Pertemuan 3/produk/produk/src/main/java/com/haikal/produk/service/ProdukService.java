package com.haikal.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haikal.produk.model.Produk;
import com.haikal.produk.repository.ProdukRepository;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }

    public Produk getProdukById(Long id) {
        return produkRepository.findById(id).orElse(null);
    }

    public Produk createProduk(Produk produk) {
        return produkRepository.save(produk);
    }

    public Produk updateProduk(Long id, Produk produk) {
        Produk existingProduk = produkRepository.findById(id).orElse(null);
        if (existingProduk != null) {
            existingProduk.setNama(produk.getNama());
            existingProduk.setSatuan(produk.getSatuan());
            existingProduk.setHarga(produk.getHarga());
            return produkRepository.save(existingProduk);
        }
        return null;
    }

    public void deleteProduk(Long id) {
        produkRepository.deleteById(id);
    }
}