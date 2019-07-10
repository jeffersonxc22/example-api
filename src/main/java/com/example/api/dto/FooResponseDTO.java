package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder("id")
@NoArgsConstructor
public class FooResponseDTO extends FooDTO {


    private Long id;


}
