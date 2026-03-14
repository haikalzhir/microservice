package com.haikal.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haikal.produk.model.Order;
import com.haikal.produk.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order simpanOrder(Order order) {
        order.setTotal(order.getHarga() * order.getJumlah());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public long hapusOrderByPelanggan(Long idPelanggan) {
        return orderRepository.deleteByIdPelanggan(idPelanggan);
    }
}