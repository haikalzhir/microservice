package com.haikal.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haikal.produk.model.Order;
import com.haikal.produk.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository OrderRepository;

    public Order simpanOrder(Order order) {
        order.setTotal(order.getHarga() * order.getJumlah());
        return OrderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return OrderRepository.findAll();
    }

    public long hapusOrderByPelanggan(Long idPelanggan) {
        return OrderRepository.deleteByIdPelanggan(idPelanggan);
    }
}