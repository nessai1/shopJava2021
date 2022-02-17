package com.awersomemarket.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Null;

@Data
@Schema(description = "Customer data")
@Validated
public class Customer {
    @Null
    @JsonProperty
    @Schema(description = "user id", required = false)
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String address;
}
