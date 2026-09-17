package com.example.shardedsagawallet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    @Schema(description = "User ID", example = "101")
    private Long id;

    @Schema(description = "User full name", example = "Mohammad Sahil")
    private String name;

    @Schema(description = "User email address", example = "sahil@example.com")
    private String email;
}


