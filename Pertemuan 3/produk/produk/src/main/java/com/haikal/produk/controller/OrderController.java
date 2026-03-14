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

import com.haikal.produk.model.Order;
import com.haikal.produk.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService OrderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return OrderService.simpanOrder(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return OrderService.getAllOrder();
    }

    @DeleteMapping("/by-pelanggan/{id}")
    public ResponseEntity<Void> deleteByPelanggan(@PathVariable("id") Long idPelanggan) {
        OrderService.hapusOrderByPelanggan(idPelanggan);
        return ResponseEntity.noContent().build();
    }
}