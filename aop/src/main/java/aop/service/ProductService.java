package aop.service;

import org.springframework.stereotype.Service;

import aop.domain.Product;

@Service
public class ProductService {
    public Product find(String name) throws RuntimeException{
        if("".equals(name)){
            throw new RuntimeException("name is null");
        }
        System.out.println("finding ...");
        return new Product(name);
    }
}