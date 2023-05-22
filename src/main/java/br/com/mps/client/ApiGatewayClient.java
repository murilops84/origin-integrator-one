package br.com.mps.client;

import br.com.mps.client.record.ClientRequestRecord;
import br.com.mps.config.feign.FeignConfig;
import br.com.mps.core.exception.ApiClientException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "gateway", url = "${api-gateway.url}", configuration = {FeignConfig.class})
public interface ApiGatewayClient {

    @PostMapping(value = "${api-gateway.uri.create}")
    void postMessage(@RequestBody ClientRequestRecord request) throws ApiClientException;

}
