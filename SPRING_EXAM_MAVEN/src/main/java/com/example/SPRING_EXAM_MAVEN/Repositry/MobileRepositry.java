package com.example.SPRING_EXAM_MAVEN.Repositry;

import org.springframework.data.repository.CrudRepository;

import com.example.SPRING_EXAM_MAVEN.Entity.MobileEntity;

public interface MobileRepositry extends CrudRepository<MobileEntity, Integer> {

}
