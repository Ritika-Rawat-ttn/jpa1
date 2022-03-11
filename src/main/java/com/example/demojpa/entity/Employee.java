package com.example.demojpa.entity;


import javax.persistence.*;


//Q-1 created  Entity which contains following fields
//
//Name
//
//Id
//
//Age
//

//Location


@Entity

public class Employee {
   // @TableGenerator(name="employee_gen" , table="id_gen",pkColumnName = "gen_name",valueColumnName = "gen_value",allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private int location;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id=id;


    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
