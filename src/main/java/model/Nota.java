package model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "note")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;




}
