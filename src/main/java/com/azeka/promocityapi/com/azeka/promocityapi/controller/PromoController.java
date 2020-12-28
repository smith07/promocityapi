package com.azeka.promocityapi.com.azeka.promocityapi.controller;

import com.azeka.promocityapi.com.azeka.promocityapi.dao.PromoRepository;
import com.azeka.promocityapi.com.azeka.promocityapi.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("promos")
public class PromoController {

    @Autowired
    PromoRepository promoRepository;


    @GetMapping
    public Iterable<Sale> getAllPromo(){
        return promoRepository.findAll();
    }

    @PostMapping
    public void addPromo(@RequestBody Sale sale){
        promoRepository.save(sale);
    }

    @PutMapping
    public void updatePromo(@RequestBody Sale sale){
        promoRepository.save(sale);
    }

}
