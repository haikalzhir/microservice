package com.haikal.produk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haikal.produk.model.Pelanggan;
import com.haikal.produk.repository.PelangganRepository;
import com.haikal.produk.service.OrderService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelanggan> getPelangganById(@PathVariable Long id) {
    return pelangganRepository.findById(id)
            .map(pelanggan -> ResponseEntity.ok().body(pelanggan))
            .orElse(ResponseEntity.notFound().build());
}

    @PostMapping
    public Pelanggan createPelanggan(@RequestBody Pelanggan pelanggan) {
        return pelangganRepository.save(pelanggan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelanggan(@PathVariable Long id) {
        // delete orders referencing this pelanggan first
        orderService.hapusOrderByPelanggan(id);
        pelangganRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
