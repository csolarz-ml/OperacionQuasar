package operation.quasar.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel(description = "Representation of a API error")
public class ApiError {


    @ApiModelProperty(value = "Error code")
    private String referenceError;

    @ApiModelProperty(value = "Http status code")
    private HttpStatus status;

    @ApiModelProperty(value = "Error description")
    private String description;


    public ApiError(

            final String referenceError,
            final HttpStatus status,
            final String description
    ) {
        super();

        this.referenceError = referenceError;
        this.status = status;
        this.description = description;
    }


    public String getReferenceError() {
        return referenceError;
    }

    public void setReferenceError(String referenceError) {
        this.referenceError = referenceError;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
