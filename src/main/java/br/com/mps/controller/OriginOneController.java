package br.com.mps.controller;

import br.com.mps.controller.record.RequestRecord;
import br.com.mps.controller.record.ResponseRecord;
import br.com.mps.core.exception.ApiClientException;
import br.com.mps.model.OriginOne;
import br.com.mps.service.IOriginOneService;
import br.com.mps.service.impl.GatewayService;
import br.com.mps.service.impl.IGatewayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OriginOneController {

    private final IOriginOneService originOneService;
    private final IGatewayService gatewayService;

    public OriginOneController(IOriginOneService originOneService, GatewayService gatewayService) {
        this.originOneService = originOneService;
        this.gatewayService = gatewayService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRecord> postOriginOne(@RequestBody RequestRecord request) throws ApiClientException {
        OriginOne originOne = originOneService.save(request.message());
        ResponseRecord response = new ResponseRecord(originOne.getId(), originOne.getMessage());
        gatewayService.postMessage(originOne);
        return ResponseEntity.ok(response);
    }

}
