package com.example.APICSharp.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Table(name = "AbstractEntity")
@EntityListeners(AuditingEntityListener.class)
public class AbstactEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="DateDeCreation")
    private Instant creationDate;

    @Column(name="DateModif")
    private Instant LastUpdateDate;

    @PrePersist
    void prePersist(){
        creationDate=Instant.now();
    }

    @PreUpdate
    void preUpdate(){
        LastUpdateDate=Instant.now();
    }
}
