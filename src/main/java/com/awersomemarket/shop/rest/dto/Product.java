package com.awersomemarket.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Schema(description = "Info about product")
@Validated
public class Product {
    @NotNull
    @Schema(description = "id", required = true)
    @JsonProperty("id")
    private Long id;

    @NotNull
    @Schema(description = "Name", required = true)
    @JsonProperty("name")
    private String name;

    @NotNull
    @Schema(description = "Price of the product", required = true)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Schema(description = "Image of the product", required = true)
    @JsonProperty("image")
    private String image;

    @NotNull
    @Schema(description = "Weight of the product", required = true)
    @JsonProperty("weight")
    private BigDecimal weight;
}
