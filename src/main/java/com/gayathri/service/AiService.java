package com.gayathri.aiportfolio.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

public String getReply(String message){

message = message.toLowerCase();

if(message.contains("skills")){

return "Gayathri is skilled in Java, Spring Boot, AI Integration and DSA.";

}

if(message.contains("project")){

return "She built AI Portfolio, Career Buddy chatbot and NutCrate ordering system.";

}

if(message.contains("contact")){

return "You can contact via the contact form.";

}

return "Hello 👋 I am Gayathri AI Assistant. Ask about skills or projects.";

}

}