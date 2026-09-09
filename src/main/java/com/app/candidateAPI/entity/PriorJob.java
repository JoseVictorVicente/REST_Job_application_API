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
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author JOSÉ VICTOR
 */
@Entity
@Table(name = "priorJob")
public class PriorJob {
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidacy_id", nullable = false)
    private Candidacy candidacy;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String lastCompany;
    
    private String phone;
    
    private LocalDate startDate;
    
    private LocalDate endDate;

    private String reasonForLeaving;
    
    private String adress;
    
    private String supervisor;
    
    private String position;
    
    private BigDecimal startSalary;
    
    private BigDecimal endSalary;
    
    private String responsabilities;

    public Candidacy getCandidacy() {
        return candidacy;
    }

    public Long getId() {
        return id;
    }

    public String getLastCompany() {
        return lastCompany;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public String getAdress() {
        return adress;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getPosition() {
        return position;
    }

    public BigDecimal getStartSalary() {
        return startSalary;
    }

    public BigDecimal getEndSalary() {
        return endSalary;
    }

    public String getResponsabilities() {
        return responsabilities;
    }

    public void setCandidacy(Candidacy candidacy) {
        this.candidacy = candidacy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastCompany(String lastCompany) {
        this.lastCompany = lastCompany;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStartSalary(BigDecimal startSalary) {
        this.startSalary = startSalary;
    }

    public void setEndSalary(BigDecimal endSalary) {
        this.endSalary = endSalary;
    }

    public void setResponsabilities(String responsabilities) {
        this.responsabilities = responsabilities;
    }
}
