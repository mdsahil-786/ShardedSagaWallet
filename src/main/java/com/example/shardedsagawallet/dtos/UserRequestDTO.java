package com.example.shardedsagawallet.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO
{
    private String name;

    private Long id;

    private String email;



}
