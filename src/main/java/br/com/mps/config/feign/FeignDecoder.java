package br.com.mps.config.feign;

import br.com.mps.controller.record.ResponseRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class FeignDecoder implements Decoder {

    @Override
    @SneakyThrows
    public ResponseRecord decode(Response response, Type type) {
        ObjectMapper mapper = new ObjectMapper();

        String responseBody = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
        ResponseRecord responseRecord = mapper.readValue(responseBody, mapper.getTypeFactory().constructType(type));

        if (Objects.nonNull(responseBody)) {
            log.debug("httpMethod={}, request={}, responseBody{}",
                    response.request().httpMethod(), response.request().url(), responseBody);
        }

        return responseRecord;

    }
}
