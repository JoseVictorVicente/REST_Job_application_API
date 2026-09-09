/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.repository;

import com.app.candidateAPI.entity.Candidacy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JOSÉ VICTOR
 */

public interface CandidateRepository extends JpaRepository<Candidacy, Long>{

}
