
package com.example.foooball_app.entity;
import com.example.foooball_app.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;


    private String username;

    private String token;
    private String password;
    private Role role_enum;

    public Role getRole_enum() {
        return role_enum;
    }

    public void setRole_enum(Role role_enum) {
        this.role_enum = role_enum;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userSponsorId", referencedColumnName = "sponsorId")
    private Sponsor sponsor;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    //    public int getSponsorId() {
//        return userSponsorId;
//    }
//
//    public void setSponsorId(int sponsorId) {
//        this.userSponsorId = sponsorId;
//    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Getters and setters
}
