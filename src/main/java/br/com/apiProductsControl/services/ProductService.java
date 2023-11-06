package br.com.apiProductsControl.services;

import br.com.apiProductsControl.dtos.ProductDTO;
import br.com.apiProductsControl.models.Product;
import br.com.apiProductsControl.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(Product product){
        this.productRepository.save(product);
    }

    public Product createProduct(ProductDTO dto) {
        Product p = new Product(dto);
        this.save(p);
        return p;
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Long productId, ProductDTO productDTO) {
        Optional<Product> existingProductOptional = productRepository.findById(productId);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.updateFromDTO(productDTO); // Implemente um método na classe Product para atualizar os campos
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }
}
