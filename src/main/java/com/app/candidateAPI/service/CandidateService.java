/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.service;

import com.app.candidateAPI.entity.Background;
import com.app.candidateAPI.entity.Candidacy;
import com.app.candidateAPI.entity.PriorJob;
import com.app.candidateAPI.entity.References;
import com.app.candidateAPI.repository.CandidateRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JOSÉ VICTOR
 */
@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    
    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }
    
    public List<Candidacy> findAll(){
        return candidateRepository.findAll();
    }
    
    public Candidacy findById(Long id) {
    return candidateRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("candidate not found: " + id));
    }
    
    @Transactional
    public Candidacy create(Candidacy candidacy) {
        if (candidacy.getBackground() != null) {
            for (Background item : candidacy.getBackground()) {
                item.setCandidacy(candidacy);
            }
        }
        if (candidacy.getReferences() != null) {
            for (References item : candidacy.getReferences()) {
                item.setCandidacy(candidacy);
            }
        }
        if (candidacy.getPriorJob() != null) {
            for (PriorJob item : candidacy.getPriorJob()) {
                item.setCandidacy(candidacy);
            }
        }
        return candidateRepository.save(candidacy);
    }

    @Transactional
    public Candidacy update(Long id, Candidacy candidacy){
        Candidacy existing = findById(id);
        existing.setObjective_Position(candidacy.getObjective_Position());
        existing.setName(candidacy.getName());
        existing.setAge(candidacy.getAge());
        existing.setCurrentDate(candidacy.getCurrentDate());
        existing.setAdress(candidacy.getAdress());
        existing.setState(candidacy.getState());
        existing.setCep(candidacy.getCep());
        existing.setTelephone(candidacy.getTelephone());
        existing.setPhone(candidacy.getPhone());
        existing.setEmail(candidacy.getEmail());
        existing.setBirthDate(candidacy.getBirthDate());
        existing.setSex(candidacy.getSex());
        existing.setFatherName(candidacy.getFatherName());
        existing.setMotherName(candidacy.getMotherName());
        existing.setMaritalStatus(candidacy.getMaritalStatus());
        existing.setSons(candidacy.getSons());
        existing.setDaughters(candidacy.getDaughters());
        existing.setWorkedInTheCompany(candidacy.getWorkedInTheCompany());
        existing.setEndDate(candidacy.getEndDate());
        existing.setOtherActivities(candidacy.getOtherActivities());
        existing.setKnowsPeopleThatWorkInTheCompany(candidacy.getKnowsPeopleThatWorkInTheCompany());
        existing.setPeopleYouKnowThatWorkInTheCompany(candidacy.getPeopleYouKnowThatWorkInTheCompany());
        existing.setSignature(candidacy.getSignature());
        replaceBackground(existing, candidacy.getBackground());
        replaceReferences(existing, candidacy.getReferences());
        replacePriorJobs(existing, candidacy.getPriorJob());
        return candidateRepository.save(existing);
    }

    private void replaceBackground(Candidacy existing, List<Background> incoming) {
        if (existing.getBackground() == null) {
            existing.setBackground(new ArrayList<>());
        }
        existing.getBackground().clear();
        if (incoming == null) {
            return;
        }
        for (Background item : incoming) {
            item.setId(null);
            item.setCandidacy(existing);
            existing.getBackground().add(item);
        }
    }

    private void replaceReferences(Candidacy existing, List<References> incoming) {
        if (existing.getReferences() == null) {
            existing.setReferences(new ArrayList<>());
        }
        existing.getReferences().clear();
        if (incoming == null) {
            return;
        }
        for (References item : incoming) {
            item.setId(null);
            item.setCandidacy(existing);
            existing.getReferences().add(item);
        }
    }

    private void replacePriorJobs(Candidacy existing, List<PriorJob> incoming) {
        if (existing.getPriorJob() == null) {
            existing.setPriorJob(new ArrayList<>());
        }
        existing.getPriorJob().clear();
        if (incoming == null) {
            return;
        }
        for (PriorJob item : incoming) {
            item.setId(null);
            item.setCandidacy(existing);
            existing.getPriorJob().add(item);
        }
    }
    
    @Transactional
    public void delete(Long id) {
    Candidacy existing = findById(id);
    candidateRepository.delete(existing);
    }
}
