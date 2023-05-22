package br.com.mps.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IKafkaService {

    void consume(ConsumerRecord<String, String> payload);
}
