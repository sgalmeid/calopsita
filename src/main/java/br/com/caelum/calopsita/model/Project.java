package br.com.caelum.calopsita.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String description;

    @ManyToOne
    private User owner;

    @ManyToMany
    private List<User> colaborators;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Iteraction> iteractions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getColaborators() {
        return colaborators;
    }

    public void setColaborators(List<User> colaborators) {
        this.colaborators = colaborators;
    }

    public List<Iteraction> getIteractions() {
        return iteractions;
    }

    public void setIteractions(List<Iteraction> iteractions) {
        this.iteractions = iteractions;
    }
}
