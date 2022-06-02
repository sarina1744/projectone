package com.revature.controllers;

import java.util.List;
import com.revature.models.Cart;
import com.revature.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.annotations.Authorized;
import com.revature.models.Role;
import com.revature.services.AuthorizationService;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    //(required = false)
    private CartService cartService;

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity<List<Cart>> findAll() {
        return ResponseEntity.ok(cartService.findAll());
    }

    @Authorized(allowedRoles = {Role.ADMIN, Role.EMPLOYEE})
    @GetMapping("/{id}")
    public ResponseEntity<Cart> findById(@PathVariable("id") int id) {
        authorizationService.guardByUserId(id);
        return ResponseEntity.ok(cartService.findById(id));
    }

    @PostMapping("/checkout")
    public String home() {
        return cartService.placeOrder();
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart c) {
        return ResponseEntity.accepted().body(cartService.addCart(c));
    }

    @PutMapping
    public ResponseEntity<Cart> updateCart(@RequestBody Cart c) {
        return ResponseEntity.accepted().body(cartService.update(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if(cartService.delete(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.noContent().build();
    }
}