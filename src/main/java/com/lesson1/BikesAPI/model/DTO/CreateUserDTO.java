package com.lesson1.BikesAPI.model.DTO;

import com.lesson1.BikesAPI.model.Role;

import java.util.List;

public record CreateUserDTO(String username, String password, Role role) {
}
