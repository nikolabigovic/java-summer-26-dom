package com.la.summer.contoller;

import com.la.summer.dto.query.FakeStoreProductDto;
import com.la.summer.service.FakeStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fakestore")
@RequiredArgsConstructor
public class FakeStoreController {

    private final FakeStoreService fakeStoreService;

    @GetMapping("product")
    public ResponseEntity<List<FakeStoreProductDto>> getAllProduct() {
        List<FakeStoreProductDto> response = fakeStoreService.getAllProduct();
        if(response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<FakeStoreProductDto> getProductById(@PathVariable Integer id) {
        FakeStoreProductDto response = fakeStoreService.getProductById(id);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("product")
    public ResponseEntity<FakeStoreProductDto> createProduct(@RequestBody FakeStoreProductDto requestBody) {
        FakeStoreProductDto response = fakeStoreService.createProduct(requestBody);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<FakeStoreProductDto> updateProductById(@PathVariable Integer id,
                                                                 @RequestBody FakeStoreProductDto requestBody)  {
        FakeStoreProductDto response = fakeStoreService.updateProductById(id, requestBody);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id)  {
        ResponseEntity<Void> response = fakeStoreService.deleteProductById(id);
        return new ResponseEntity<>(response.getStatusCode());
    }

    @GetMapping("product-bean/{id}")
    public ResponseEntity<FakeStoreProductDto> getProductByIdBean(@PathVariable Integer id) {
        FakeStoreProductDto response = fakeStoreService.getProductByIdBean(id);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
