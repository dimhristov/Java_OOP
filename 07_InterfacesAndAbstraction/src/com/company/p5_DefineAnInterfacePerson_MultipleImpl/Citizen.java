package com.company.p5_DefineAnInterfacePerson_MultipleImpl;

public class Citizen implements Person, Birthable, Identifiable {
    private String name;
    private Integer age;
    private String birthday;
    private String id;

    public Citizen(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Citizen(String name, Integer age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }


    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getID() {
        return this.id;
    }
}
