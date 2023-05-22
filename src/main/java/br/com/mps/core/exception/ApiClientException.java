package br.com.mps.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiClientException extends Exception {

    private static final long serialVersionUID = -7211579582755677566L;

    public ApiClientException(String message, String detail) {
        super(String.format(message, detail));
    }

    public ApiClientException(String message, String[] detail) {
        super(String.format(message, (Object) detail));
    }
}
