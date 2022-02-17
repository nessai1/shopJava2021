package com.awersomemarket.shop.rest.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema(description = "List of product positions")
@Validated
public class Positions {

    @NotNull
    @Schema(description = "List of product positions", required = true)
    @JsonProperty("products")
    private List<Position> positionList;
}
