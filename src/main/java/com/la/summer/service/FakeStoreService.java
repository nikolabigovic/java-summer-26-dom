package com.la.summer.service;

import com.la.summer.dto.query.FakeStoreProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;


@Service
@RequiredArgsConstructor
public class FakeStoreService {

    private final RestClient restClient;

    public FakeStoreProductDto getProductById(Integer id) {
        RestClient restClient = RestClient.create();
//        RestTemplate restTemplate = new RestTemplate();
       return restClient.get()
                .uri("https://fakestoreapi.com/products/{id}", id)
                .retrieve()
                .body(FakeStoreProductDto.class);

    }

    public List<FakeStoreProductDto> getAllProduct() {
        RestClient restClient = RestClient.create();
        ParameterizedTypeReference<List<FakeStoreProductDto>> responseBody = new ParameterizedTypeReference<List<FakeStoreProductDto>>() {};

        return restClient.get()
                .uri("https://fakestoreapi.com/products")
                .retrieve()
                .body(responseBody);
    }

    public FakeStoreProductDto createProduct(FakeStoreProductDto requestBody) {
        RestClient restClient = RestClient.create();
        return restClient.post()
                .uri("https://fakestoreapi.com/products")
                .body(requestBody)
                .retrieve()
                .body(FakeStoreProductDto.class);
    }

    public FakeStoreProductDto updateProductById(Integer id, FakeStoreProductDto requestBody) {
        RestClient restClient = RestClient.create();
        Integer indet = id;
        return restClient.put()
                .uri("https://fakestoreapi.com/products/{indet}", indet)
                .body(requestBody)
                .retrieve()
                .body(FakeStoreProductDto.class);
    }

    public ResponseEntity<Void> deleteProductById(Integer id) {
        RestClient restClient = RestClient.create();
        return restClient.delete()
                .uri("https://fakestoreapi.com/products/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }

    public FakeStoreProductDto getProductByIdBean(Integer id) {
        return restClient.get()
                .uri("/product/{id}", id)
                .retrieve()
                .body(FakeStoreProductDto.class);
    }
}
