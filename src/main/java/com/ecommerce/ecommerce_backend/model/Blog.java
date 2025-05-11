package com.ecommerce.ecommerce_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String cover;

    private String category;

    @Column(columnDefinition = "TEXT") // to support HTML content
    private String content;

    private LocalDateTime datePosted;

    @PrePersist
    public void prePersist() {
        this.datePosted = LocalDateTime.now();
    }
}
