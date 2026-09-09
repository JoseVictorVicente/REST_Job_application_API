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
@RequestMapping("/admin/candidate")
public class AdminCandidateController {
    private final CandidateService candidateService;
    
    public AdminCandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }
    
        @GetMapping
        public ResponseEntity<List<Candidacy>> findAll(){
            return ResponseEntity.ok(candidateService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Candidacy> findById(@PathVariable Long id){
            return ResponseEntity.ok(candidateService.findById(id));
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            candidateService.delete(id);
            return ResponseEntity.noContent().build();
        }
}
