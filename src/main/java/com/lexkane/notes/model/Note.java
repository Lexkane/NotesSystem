package com.lexkane.notes.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "note")
    private String note;

   // @OneToMany(mappedBy = "id")
    @Column(name="user_code")
    private Long userCode;
}
