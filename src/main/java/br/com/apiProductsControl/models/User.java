package br.com.apiProductsControl.models;

import br.com.apiProductsControl.dtos.UserLoginDTO;
import br.com.apiProductsControl.dtos.UserPostDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String cel;
    @Embedded
    private Address address;
    private Boolean ativo;

    public User(UserPostDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.password = dto.password();
        this.cel = dto.cel();
        this.address = dto.address();
        this.ativo = true;
    }

    public User(UserLoginDTO dto) {
        this.email = dto.email();
        this.password = dto.password();
    }
}
