package br.com.apiProductsControl.dtos;

import br.com.apiProductsControl.models.Address;

public record UserPostDTO(String name, String email, String password, String cel, Address address) {
}
