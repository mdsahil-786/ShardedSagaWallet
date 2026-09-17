package com.example.shardedsagawallet.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferRequestDTO {

    @NotNull(message = "Source wallet ID is required")
    @Positive(message = "Source wallet ID must be positive")
    @Schema(description = "Source wallet ID", example = "1")
    private Long fromWalletId;

    @NotNull(message = "Destination wallet ID is required")
    @Positive(message = "Destination wallet ID must be positive")
    @Schema(description = "Destination wallet ID", example = "2")
    private Long toWalletId;

    @NotNull(message = "Transfer amount is required")
    @DecimalMin(value = "0.01", message = "Transfer amount must be greater than zero")
    @Schema(description = "Amount to transfer", example = "1500.00")
    private BigDecimal amount;

    @Schema(description = "Transfer description", example = "Monthly rent payment")
    private String description;
}
