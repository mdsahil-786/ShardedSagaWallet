package com.example.shardedsagawallet.dtos;

import com.example.shardedsagawallet.enums.SagaStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponseDTO {

    @Schema(description = "Saga instance ID", example = "5001")
    private Long sagaInstanceId;


}

