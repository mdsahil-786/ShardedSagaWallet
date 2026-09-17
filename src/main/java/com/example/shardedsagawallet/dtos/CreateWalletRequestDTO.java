package com.example.shardedsagawallet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateWalletRequestDTO {

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be positive")
    @Schema(description = "User ID for wallet creation", example = "101")
    private Long userId;
}

