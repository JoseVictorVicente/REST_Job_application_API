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
import java.time.LocalDate;


/**
 *
 * @author JOSÉ VICTOR
 */

@Entity
@Table(name = "background")
public class Background {
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidacy_id", nullable = false)
    private Candidacy candidacy;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String schoolOrCollege;
    
    private String agency;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean graduated;
    
    private String grade;

    public Candidacy getCandidacy() {
        return candidacy;
    }

    public Long getId() {
        return id;
    }

    public String getSchoolOrCollege() {
        return schoolOrCollege;
    }

    public String getAgency() {
        return agency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getGraduated() {
        return graduated;
    }

    public String getGrade() {
        return grade;
    }

    public void setCandidacy(Candidacy candidacy) {
        this.candidacy = candidacy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSchoolOrCollege(String schoolOrCollege) {
        this.schoolOrCollege = schoolOrCollege;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
}
