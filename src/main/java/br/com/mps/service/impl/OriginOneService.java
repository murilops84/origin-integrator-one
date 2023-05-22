package br.com.mps.service.impl;

import br.com.mps.dao.OriginOneRepository;
import br.com.mps.model.OriginOne;
import br.com.mps.service.IOriginOneService;
import org.springframework.stereotype.Service;

@Service
public class OriginOneService implements IOriginOneService {

    private OriginOneRepository originOneRepository;

    public OriginOneService(OriginOneRepository originOneRepository) {
        this.originOneRepository = originOneRepository;
    }

    @Override
    public OriginOne save(String message) {
        OriginOne originOne = OriginOne.builder()
                .message(message)
                .build();
        return originOneRepository.save(originOne);
    }
}
