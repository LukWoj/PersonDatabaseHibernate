package pl.lukwoj.spring.model;

import pl.lukwoj.spring.model.forms.PersonForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@Column(name = "aaaa")
    private String name;
    private String surname;
    private int age;
    private String mobile;
    private String email;

    public Person() {
    }

    public Person(PersonForm personForm) {
        name = personForm.getName();
        surname = personForm.getSurname();
        age = personForm.getAge();
        mobile = personForm.getMobile();
        email = personForm.getEmail();
    }

    public Person(String name, String surname, int age, String mobile, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
