package com.awersomemarket.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class Order {

    @NotNull
    @JsonProperty
    @Schema(description = "id", required = true)
    private Long id;

    @NotNull
    @Schema(description = "Customer name", required = true)
    @JsonProperty("customer")
    private String customer;

//    @NotNull
//    @Schema(description = "Customer name", required = true)
//    @JsonProperty("customer")
//    private String ;
}
