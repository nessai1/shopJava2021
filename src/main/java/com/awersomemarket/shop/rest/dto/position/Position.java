package com.awersomemarket.shop.rest.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Position of the product")
@Validated
public class Position {


    @NotNull
    @JsonProperty
    @Schema(description = "Product ID", required = true)
    private Long id;

    @NotNull
    @JsonProperty
    @Schema(description = "Count of product position", required = true)
    private Double count;

}
