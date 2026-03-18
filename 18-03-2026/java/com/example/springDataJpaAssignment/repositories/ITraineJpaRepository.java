package com.example.springDataJpaAssignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDataJpaAssignment.entities.Trainee;

public interface ITraineJpaRepository extends JpaRepository<Trainee, Integer>{

}
