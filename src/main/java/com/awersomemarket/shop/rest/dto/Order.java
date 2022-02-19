package com.awersomemarket.shop.rest.dto;

import com.awersomemarket.shop.orders.OrderStatus;
import com.awersomemarket.shop.rest.dto.position.Position;
import com.awersomemarket.shop.rest.dto.position.Positions;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Data
@Schema(description = "Order data")
@Validated
public class Order {

    @Null
    @JsonProperty
    @Schema(description = "id", required = false)
    private Long id;

    @NotNull
    @JsonProperty
    @Schema(description = "Order address", required = true)
    private String address;

    @NotNull
    @JsonProperty
    @Schema(description = "Customer data", required = true)
    private Customer user;

    @Null
    @JsonProperty("status")
    @Schema(description = "Status of the order", required = false)
    private OrderStatus orderStatus;

    @NotNull
    @Schema(description = "List of product positions", required = true)
    @JsonProperty("products")
    private List<Position> positionList;
}
