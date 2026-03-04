package com.gayathri.aiportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gayathri.aiportfolio.entity.Project;

public interface ProjectRepository
extends JpaRepository<Project,Long>{

}