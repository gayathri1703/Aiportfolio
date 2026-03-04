package com.gayathri.aiportfolio.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AIController {

@PostMapping("/ai/chat")

public String chat(

@RequestParam String message){

String msg = message.toLowerCase();


// PROJECTS

if(msg.contains("project")){

return "Gayathri built AI Portfolio, Career Buddy AI chatbot, and NutCrate Online Nut Ordering System.";

}


// SKILLS

if(msg.contains("skills")){

return "Skills include Java, Spring Boot, DSA, AI Integration, Full Stack Development.";

}


// ABOUT

if(msg.contains("about")){

return "Gayathri is an AI-focused backend developer passionate about building intelligent systems.";

}


// CONTACT

if(msg.contains("contact")){

return "You can contact her via LinkedIn or Email available in portfolio.";

}


return "Hello 👋 Ask about projects, skills or experience!";

}

}