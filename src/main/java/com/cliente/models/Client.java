package com.cliente.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document(collection = "client")
public class Client {

    @Id
    private String id;
    private String name;
    private LocalDate dob;
    private String cpf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge(){
        int age = 0;
        if (this.dob != null){
            age = Period.between(this.dob, LocalDate.now()).getYears();
        }
        return age;
    }
}
