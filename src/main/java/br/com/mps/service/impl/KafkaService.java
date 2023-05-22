package br.com.mps.service.impl;

import br.com.mps.service.IKafkaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class KafkaService implements IKafkaService {

    private final String topicName;

    public KafkaService(@Value("${topic.name.consumer") String topicName) {
        this.topicName = topicName;
    }

    @Override
    @KafkaListener(topics = "${topic.name.consumer}", groupId = "origin_one")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("key: {}", payload.key());
        log.info("Headers: {}", new String(payload.headers().lastHeader("origin").value(), StandardCharsets.UTF_8));
        log.info("Partition: {}", payload.partition());
        log.info("Order: {}", payload.value());
    }
}
