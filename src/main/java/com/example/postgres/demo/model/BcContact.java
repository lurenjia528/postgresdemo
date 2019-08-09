package com.example.postgres.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author yanggt
 * @date 19-8-8
 */
@Entity(name = "bc_contact")
@Data
@Getter
@Setter
public class BcContact {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Column(name = "quality")
    private Integer quality;

    @Override
    public String toString() {
        return "BcContact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", quality=" + quality +
                '}';
    }
}
