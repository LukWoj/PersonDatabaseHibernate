package pl.lukwoj.spring.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.*;


public class Person {
    @NotEmpty //walidacja
    @Size(min=3, max=25)
    private String name;
    @NotEmpty
    @Max(value = 25)
    @Min(value = 3)
    private String surname;

    private int age;
    @NotEmpty
    @Pattern(regexp ="[0-9]{3}-[0-9]{3}-[0-9]{3}")
    private String mobile;
    @NotEmpty
    @Email
    private String email;

    //wiecej niż 3 argumenty konstruktora. Nalezy zatosować wzorzec budowniczy
    public Person(String name, String surname, int age, String mobile, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
    }

    private Person(Builder builder) {
        name = builder.name;
        surname = builder.name;
        age = builder.age;
        mobile = builder.mobile;
        email = builder.mobile;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private String mobile;
        private String email;

        public Builder(String name){
            this.name = name;
        }

        public Builder setSurname(String Surname){
            this.surname = surname;
        return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setMobile(String mobile){
            this.mobile = mobile;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

}
