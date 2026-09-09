/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author JOSÉ VICTOR
 */

@Entity
@Table (name = "personal_references")
public class References {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String relationship;
    
    private String company;
    
    private String phone;
    
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidacy_id", nullable = false)
    private Candidacy candidacy;   
    
    public void setCandidacy(Candidacy candidacy){
        this.candidacy = candidacy;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setRelationship(String relationship){
        this.relationship = relationship;
    }
    
    public void setCompany(String company){
        this.company = company;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public Long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getRelationship(){
        return relationship;
    }
    
    public String getCompany(){
        return company;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public Candidacy getCandidacy(){
        return candidacy;
    }
}
