package com.moonlight.commonutility.mappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.moonlight.commonutility.constants.AppConstants;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppErrors {
    private String status;
    private Object errors;
    public AppErrors(Object errors) {
        this.errors = errors;
        status = AppConstants.FAIL;
    }
}
