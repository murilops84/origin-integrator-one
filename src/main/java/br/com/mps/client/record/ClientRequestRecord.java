package br.com.mps.client.record;

import lombok.Builder;

@Builder
public record ClientRequestRecord(Long id, String message, String origin) {
}
