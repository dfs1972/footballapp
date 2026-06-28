package org.footballapp.tools;

/**
 * Represents the result of an API endpoint test.
 *
 * This model is shared by ApiTester methods and
 * contains all information about a single request.
 */
public class ApiTestResult {

    /**
     * API endpoint that was requested.
     */
    private String endpoint;

    /**
     * Raw JSON returned by the API.
     */
    private String json;

    /**
     * Pretty formatted JSON.
     */
    private String formattedJson;

    /**
     * Time taken to complete the request.
     */
    private long elapsedTime;

    /**
     * Response size in bytes.
     */
    private int responseSize;

    /**
     * Timestamp of the request.
     */
    private String timestamp;

    /**
     * Output file location.
     *
     * Null if the response has not been saved.
     */
    private String outputFile;

    /**
     * Indicates whether validation succeeded.
     */
    private boolean valid;

    /**
     * Model class used for validation.
     */
    private String validatedClass;

    /**
     * Exception message if validation fails.
     */
    private String exceptionMessage;

    /**
     * Validation message.
     */
    private String validationMessage;

    public String getValidatedClass() {
        return validatedClass;
    }

    public void setValidatedClass(String validatedClass) {
        this.validatedClass = validatedClass;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Getters and Setters
     */
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getFormattedJson() {
        return formattedJson;
    }

    public void setFormattedJson(String formattedJson) {
        this.formattedJson = formattedJson;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(
            String validationMessage
    ) {
        this.validationMessage =
                validationMessage;
    }
}