package com.gayathri.aiportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gayathri.aiportfolio.entity.ContactMessage;

public interface ContactRepository
extends JpaRepository<ContactMessage,Long>{

}