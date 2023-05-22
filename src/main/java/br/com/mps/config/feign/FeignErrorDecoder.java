package br.com.mps.config.feign;

import br.com.mps.core.exception.ApiClientException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;

@Slf4j
public class FeignErrorDecoder extends ErrorDecoder.Default {

    private final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    @Override
    @SneakyThrows
    public Exception decode(String methodKey, Response response) {
        String responseBody = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        Exception defaultException = defaultDecoder.decode(methodKey, response);

        if (responseStatus.is4xxClientError() || responseStatus.is5xxServerError()) {
            return new ApiClientException("Got %s response from %s, response body: %s",
                    new String[]{String.valueOf(response.status()), methodKey, responseBody});
        }
        return defaultException;
    }
}
