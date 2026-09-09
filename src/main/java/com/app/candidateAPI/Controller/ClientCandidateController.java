/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.candidateAPI.Controller;

import com.app.candidateAPI.entity.Candidacy;
import com.app.candidateAPI.service.CandidateService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JOSÉ VICTOR
 */
@RestController
@RequestMapping("/client/candidate")
public class ClientCandidateController {
    private final CandidateService candidateService;
    
    public ClientCandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

        @PostMapping
        public ResponseEntity<Candidacy> create(@RequestBody Candidacy candidacy){
            return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(candidacy));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Candidacy> update(@PathVariable Long id, @RequestBody Candidacy candidacy){
            return ResponseEntity.ok(candidateService.update(id, candidacy));
        }

}
