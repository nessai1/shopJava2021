package com.awersomemarket.shop.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema
@Validated
public class Products {
    @NotNull
    @Schema(description = "List of products", required = true)
    @JsonProperty("product_list")
    private List<Product> productList;
}
