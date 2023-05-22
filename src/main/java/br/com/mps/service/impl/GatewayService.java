package br.com.mps.service.impl;

import br.com.mps.client.ApiGatewayClient;
import br.com.mps.client.record.ClientRequestRecord;
import br.com.mps.core.exception.ApiClientException;
import br.com.mps.model.OriginOne;
import org.springframework.stereotype.Service;

@Service
public class GatewayService implements IGatewayService {

    private final ApiGatewayClient apiGatewayClient;

    private static final String ORIGIN = "Origin One";

    public GatewayService(ApiGatewayClient apiGatewayClient) {
        this.apiGatewayClient = apiGatewayClient;
    }

    @Override
    public void postMessage(OriginOne request) throws ApiClientException {
        ClientRequestRecord clientRequest = ClientRequestRecord.builder()
                .id(request.getId())
                .message(request.getMessage())
                .origin(ORIGIN)
                .build();
        apiGatewayClient.postMessage(clientRequest);
    }
}
