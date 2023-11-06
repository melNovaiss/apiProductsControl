package br.com.apiProductsControl.models;

import br.com.apiProductsControl.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String oferta;

    public Product(ProductDTO dto) {
        this.name = dto.name();
        this.price = dto.price();
        this.oferta = dto.oferta();
    }

    public void updateFromDTO(ProductDTO dto) {
        if (dto.name() != null) {
            this.setName(dto.name());
        }
        if (dto.price() != null) {
            this.setPrice(dto.price());
        }
        if (dto.oferta() != null) {
            this.setOferta(dto.oferta());
        }
    }
}
