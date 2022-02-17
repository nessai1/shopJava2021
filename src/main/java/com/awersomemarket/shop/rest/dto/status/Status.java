package com.awersomemarket.shop.rest.dto.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Schema(description = "Request status object")
@Validated
public class Status {

    @NotNull
    @JsonProperty
    @Schema(description = "Status ID", required = true)
    private StatusCode code;

    @Null
    @JsonProperty
    @Schema(description = "Error description if statusCode != OK")
    private String errorDescription;
}
