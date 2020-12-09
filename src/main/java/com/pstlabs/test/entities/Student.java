package com.pstlabs.test.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personDataId")
    @NotNull
    private PersonData personData;
    @Column(name = "GROUP_NAME")
    private String groupName;
    @ManyToMany
    @JoinTable(
            name = "student_subjects",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "subjectId"))
    @JsonIgnore
    private List<Subject> subjects;
}
