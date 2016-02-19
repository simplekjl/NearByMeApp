package projects.devdreamers.nearbymeapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by admin on 2/15/2016.
*/
public class Response {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("error_type")
    @Expose
    private String errorType;
    @SerializedName("error_message")
    @Expose
    private String errorMessage;

    /**
     *
     * @return
     * The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The errorType
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     *
     * @param errorType
     * The error_type
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     *
     * @return
     * The errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     *
     * @param errorMessage
     * The error_message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}