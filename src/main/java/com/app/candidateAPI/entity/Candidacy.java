/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author JOSÉ VICTOR
 */

@Entity
@Table(name = "candidacy")
public class Candidacy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String Objective_Position;
    
    private String name;
    
    private Integer age;
    
    @Column(name = "form_date")
    private LocalDate currentDate;
    
    private String adress;
    
    private String state;
    
    private String cep;
    
    private String telephone;
    
    private String phone;
    
    private String email;
    
    private LocalDate birthDate;
    
    private String sex;
    
    private String fatherName;
    
    private String motherName;
    
    private String maritalStatus;
    
    private Boolean sons;
    
    private Boolean daughters;
    
    private Boolean workedInTheCompany;
    
    private LocalDate endDate;
    
    private String otherActivities;
    
    private Boolean knowsPeopleThatWorkInTheCompany;
    
    private String peopleYouKnowThatWorkInTheCompany;
    
    private Boolean signature;
    
            
    @OneToMany(mappedBy = "candidacy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Background> background;
    @OneToMany(mappedBy = "candidacy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<References> references;
    @OneToMany(mappedBy = "candidacy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriorJob> priorJob;

    public Long getId() {
        return id;
    }

    public String getObjective_Position() {
        return Objective_Position;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public String getAdress() {
        return adress;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public Boolean getSons() {
        return sons;
    }

    public Boolean getDaughters() {
        return daughters;
    }

    public Boolean getWorkedInTheCompany() {
        return workedInTheCompany;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getOtherActivities() {
        return otherActivities;
    }

    public Boolean getKnowsPeopleThatWorkInTheCompany() {
        return knowsPeopleThatWorkInTheCompany;
    }

    public String getPeopleYouKnowThatWorkInTheCompany() {
        return peopleYouKnowThatWorkInTheCompany;
    }

    public Boolean getSignature() {
        return signature;
    }

    public List<Background> getBackground() {
        return background;
    }

    public List<References> getReferences() {
        return references;
    }

    public List<PriorJob> getPriorJob() {
        return priorJob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setObjective_Position(String Objective_Position) {
        this.Objective_Position = Objective_Position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setSons(Boolean sons) {
        this.sons = sons;
    }

    public void setDaughters(Boolean daughters) {
        this.daughters = daughters;
    }

    public void setWorkedInTheCompany(Boolean workedInTheCompany) {
        this.workedInTheCompany = workedInTheCompany;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setOtherActivities(String otherActivities) {
        this.otherActivities = otherActivities;
    }

    public void setKnowsPeopleThatWorkInTheCompany(Boolean knowsPeopleThatWorkInTheCompany) {
        this.knowsPeopleThatWorkInTheCompany = knowsPeopleThatWorkInTheCompany;
    }

    public void setPeopleYouKnowThatWorkInTheCompany(String peopleYouKnowThatWorkInTheCompany) {
        this.peopleYouKnowThatWorkInTheCompany = peopleYouKnowThatWorkInTheCompany;
    }

    public void setSignature(Boolean signature) {
        this.signature = signature;
    }

    public void setBackground(List<Background> background) {
        this.background = background;
    }

    public void setReferences(List<References> references) {
        this.references = references;
    }

    public void setPriorJob(List<PriorJob> priorJob) {
        this.priorJob = priorJob;
    }
    
    
}
