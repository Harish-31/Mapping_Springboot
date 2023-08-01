package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TutorialModel;
import com.example.demo.repository.TutorialRepository;

@RestController
@RequestMapping("/api")

public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    //GET BY ID
    @GetMapping("/show/{id}")
    public Optional<TutorialModel> findbyid(@PathVariable Long id){
        return (Optional<TutorialModel>) tutorialRepository.findById(id);
    }

    //DELETE BY ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        Optional<TutorialModel> ____tutorial = tutorialRepository.findById(id);
        if (____tutorial != null) {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}