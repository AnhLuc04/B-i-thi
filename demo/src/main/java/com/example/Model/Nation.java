package com.example.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Size(min = 2, max =50,message = "Xin Mời Nhập Lại")
    @NotNull
    private String nameNation;
    public Nation() {
    }

    public Nation(Long ID, @NotNull String nameNation) {
        this.ID = ID;
        this.nameNation = nameNation;
    }

    public Nation(@NotNull String nameNation) {
        this.nameNation = nameNation;
    }

    public Long getID() {
        return ID;
    }


    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }


}
