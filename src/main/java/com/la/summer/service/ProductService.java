package com.la.summer.service;

import com.la.summer.dto.command.ProductCreateDto;
import com.la.summer.dto.query.ProductDto;
import com.la.summer.model.Product;
import com.la.summer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAll() {
        List<ProductDto> productDtoList = new ArrayList<>();

        List<Product> productList = productRepository.getAll();
        for(Product product : productList) {
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName().toUpperCase());
            productDto.setPrice(product.getPrice());
            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    public ProductDto getById(Integer id) {
        Product product = productRepository.getById(id);
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName().toUpperCase());
        productDto.setPrice(product.getPrice());

        return productDto;
    }

    public List<Product> getByPriceAndName(Double price, String name) {
        return productRepository.getByPriceAndName(price, name);
    }

    public Product create(ProductCreateDto body) {
        return productRepository.create(body);
    }

    public Product update(Integer id, ProductCreateDto body) {
        return productRepository.update(id, body);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }

    public void readHeader(Map<String, String> requestHeaders) {
        log.info("Username header: {}", requestHeaders.get("Username"));
        log.info("Password header: {}", requestHeaders.get("Password"));
    }

    public void readHeaderSpring(HttpHeaders httpHeaders) {
        log.info("Username header: {}", httpHeaders.get("Username"));
        log.info("Password header: {}", httpHeaders.get("Password"));
        log.info("Print all: {}", httpHeaders);
    }

    public HttpHeaders returnHeaders() {
        HttpHeaders customHeader = new HttpHeaders();
        customHeader.add("Korisnik", "sradenovic");
        customHeader.add("Sifra", "****t****");

        return customHeader;
    }
}
