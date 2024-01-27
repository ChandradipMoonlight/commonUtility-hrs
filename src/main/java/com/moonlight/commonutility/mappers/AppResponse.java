package com.moonlight.commonutility.mappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.moonlight.commonutility.constants.AppConstants;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppResponse {
    private Object data;
    private String status;
    public AppResponse(Object data) {
        this.data = data;
        this.status = AppConstants.SUCCESS;
    }

}
