package com.coord.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "coord")

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor

public class Coord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lat;
    private String lon;
    private Double x;
    private Double y;
    private Double z;
    private Integer stn;
    
    @ManyToOne
    @JoinColumn(name = "id_sismica2d")
    private Sismica2d sismica2d;
    
}
