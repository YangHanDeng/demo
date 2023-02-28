package com.example.demo.user;

import jakarta.persistence.*;

@Entity //for hybinate
@Table // for table in our database
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    //Generate: alt+insert
    private long uid;
    private String name;
    private Integer coins;
    // @Transient : don't store this to database
    private Integer age;
    private String email;
    public Users(){

    }
    public Users(long uid, String name, Integer coins, Integer age, String email){
        this.uid = uid;
        this.name = name;
        this.coins = coins;
        this.age = age;
        this.email = email;
    }
    public Users(String name, Integer coins, Integer age, String email){
        this.name = name;
        this.coins = coins;
        this.age = age;
        this.email = email;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", coins='" + coins + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
