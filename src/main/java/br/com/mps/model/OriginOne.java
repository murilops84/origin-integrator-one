package br.com.mps.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "OriginOne", schema = "public")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OriginOne implements Serializable {

    @Serial
    private static final long serialVersionUID = -3660882769386432715L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "origin_one_gen")
    @SequenceGenerator(name = "origin_one_gen", sequenceName = "origin_one_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "responseId")
    private Long responseId;


}
