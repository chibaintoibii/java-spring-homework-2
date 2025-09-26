package org.example;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "substances")
public class Substance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "measurement_unit", nullable = false)
    private String measurement_unit;

    @ManyToMany()
    @JoinTable(
            name = "substance_causes",
            joinColumns = @JoinColumn(name = "substance_id"),
            inverseJoinColumns = @JoinColumn(name = "cause_id")
    )
    private List<Cause> causes = new ArrayList<Cause>();
}
