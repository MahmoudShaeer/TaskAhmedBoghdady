package com.example.mahmoudshaeer.taskahmedboghdady.model.apiResponse;

import java.util.ArrayList;

/**
 * Created by Mahmoud Shaeer on 11/08/2017.
 */

public class ResponseShowResult {
    private boolean success;
    private String message;
    private ArrayList<Results> results = new ArrayList<>();

    public ResponseShowResult() {
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public ResponseShowResult(boolean success, String message, ArrayList<Results> results) {
        this.success = success;
        this.message = message;
        this.results = results;
    }
}
