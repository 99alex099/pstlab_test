package com.pstlabs.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonData")
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personDataId")
    @JsonIgnore
    private Long personDataId;
    @Column
    private String fullName;
    @Column
    private Integer age;
}
