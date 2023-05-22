package br.com.mps.service.impl;

import br.com.mps.core.exception.ApiClientException;
import br.com.mps.model.OriginOne;

public interface IGatewayService {

    void postMessage(OriginOne request) throws ApiClientException;

}
