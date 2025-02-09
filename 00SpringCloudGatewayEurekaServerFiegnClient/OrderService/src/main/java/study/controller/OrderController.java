package study.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import study.dto.Product;
import study.feignClient.ProductClient;
import study.model.Orders;

import study.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductClient productClient;

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    @PostMapping("/create")
    public Orders createOrder(@RequestBody Orders order) {
    	
        order.setOrderDate(LocalDate.now());
        return orderRepository.save(order);
    }
    
    @PostMapping("/add")
    public Orders addOrder(@RequestBody Orders order) {
        Product product = productClient.getProductById(order.getProductId());
        if (product != null) {
        	order.setOrderDate(LocalDate.now());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
    
    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders orderDetails) {
        Optional<Orders> order = orderRepository.findById(id);

        if (order.isPresent()) {
            Orders orderToUpdate = order.get();
            orderToUpdate.setProductId(orderDetails.getProductId());
            orderToUpdate.setQuantity(orderDetails.getQuantity());
            return orderRepository.save(orderToUpdate);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
