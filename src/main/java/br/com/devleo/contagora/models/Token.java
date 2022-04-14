package br.com.devleo.contagora.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Instant momentTokenCreated;
    private Instant momentTokenExpire;
    private Instant momentTokenUsed;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public Token() {
    }

    public Token(String token, Instant momentTokenCreated,
            Instant momentTokenExpire,
            User user) {
        this.token = token;
        this.momentTokenCreated = momentTokenCreated;
        this.momentTokenExpire = momentTokenExpire;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getMomentTokenCreated() {
        return momentTokenCreated;
    }

    public void setMomentTokenCreated(Instant momentTokenCreated) {
        this.momentTokenCreated = momentTokenCreated;
    }

    public Instant getMomentTokenExpire() {
        return momentTokenExpire;
    }

    public void setMomentTokenExpire(Instant momentTokenExpire) {
        this.momentTokenExpire = momentTokenExpire;
    }

    public Instant getMomentTokenUsed() {
        return momentTokenUsed;
    }

    public void setMomentTokenUsed(Instant momentTokenUsed) {
        this.momentTokenUsed = momentTokenUsed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
