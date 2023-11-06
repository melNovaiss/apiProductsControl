package br.com.apiProductsControl.controllers;

import br.com.apiProductsControl.dtos.ProductDTO;
import br.com.apiProductsControl.models.Product;
import br.com.apiProductsControl.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listar(){
        List<Product> p = this.productService.findAll();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping("/form")
    public  ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        Product p = productService.createProduct(dto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping("/form/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = productService.updateProduct(productId, productDTO);
        if (updatedProduct != null) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update product", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        productService.deleteById(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
