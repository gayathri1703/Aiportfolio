package com.gayathri.aiportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gayathri.aiportfolio.entity.ContactMessage;
import com.gayathri.aiportfolio.entity.Project;
import com.gayathri.aiportfolio.repository.ContactRepository;
import com.gayathri.aiportfolio.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession; 

@Controller
public class HomeController {

private final ContactRepository contactRepository;
private final ProjectRepository projectRepository;


public HomeController(

ContactRepository contactRepository,

ProjectRepository projectRepository){

this.contactRepository = contactRepository;

this.projectRepository = projectRepository;

}


// HOME PAGE
@GetMapping("/")
public String home(Model model){

model.addAttribute("name","Gayathri");

model.addAttribute(

"projects",

projectRepository.findAll());

return "index";

}


// CONTACT PAGE
@GetMapping("/contact")
public String contactPage(){

return "contact";

}


// SAVE CONTACT MESSAGE
@PostMapping("/contact")
public String contactSubmit(

@RequestParam String name,
@RequestParam String email,
@RequestParam String message){

ContactMessage contact = new ContactMessage();

contact.setName(name);
contact.setEmail(email);
contact.setMessage(message);

contactRepository.save(contact);

System.out.println("Saved into Database Successfully!");

return "redirect:/?success=true";

}


// ADMIN LOGIN PAGE
@GetMapping("/admin/login")
public String adminLogin(){

return "admin-login";

}


// ADMIN LOGIN CHECK ✅ SESSION ADDED
@PostMapping("/admin/login")
public String loginCheck(

@RequestParam String username,
@RequestParam String password,
HttpSession session){

if(username.equals("admin") &&
password.equals("1234")){

// ✅ LOGIN SUCCESS SESSION
session.setAttribute("admin","true");

return "redirect:/admin/dashboard";

}

return "redirect:/admin/login";

}


// SHOW MESSAGES ✅ LOGIN PROTECTION ADDED
@GetMapping("/admin/messages")
public String showMessages(
Model model,
HttpSession session){

// BLOCK DIRECT ACCESS
if(session.getAttribute("admin")==null){

return "redirect:/admin/login";

}

model.addAttribute("messages",
contactRepository.findAll());

return "messages";

}


// ADMIN DASHBOARD
@GetMapping("/admin/dashboard")
public String adminDashboard(
Model model,
HttpSession session){

// PROTECT DASHBOARD
if(session.getAttribute("admin")==null){

return "redirect:/admin/login";

}

long totalMessages = contactRepository.count();

model.addAttribute("totalMessages", totalMessages);

return "admin-dashboard";

}
@GetMapping("/admin/add-project")

public String addProjectPage(){

return "add-project";

}
@PostMapping("/admin/add-project")

public String saveProject(

@RequestParam String title,

@RequestParam String description,

@RequestParam String githubLink,

@RequestParam String imageUrl){

Project project = new Project();

project.setTitle(title);

project.setDescription(description);

project.setGithubLink(githubLink);

project.setImageUrl(imageUrl);

projectRepository.save(project);

return "redirect:/admin/dashboard";

}


// LOGOUT ✅ SESSION REMOVE
@GetMapping("/admin/logout")
public String logout(HttpSession session){

session.invalidate();

return "redirect:/admin/login";

}


// DELETE MESSAGE ✅ LOGIN PROTECTION
@GetMapping("/admin/delete/{id}")
public String deleteMessage(
@PathVariable Long id,
HttpSession session){

if(session.getAttribute("admin")==null){

return "redirect:/admin/login";

}

contactRepository.deleteById(id);

System.out.println("Message Deleted Successfully!");

return "redirect:/admin/messages";

}


@GetMapping("/admin/delete-project/{id}")
public String deleteProject(
@PathVariable Long id,
HttpSession session){

// login protection
if(session.getAttribute("admin")==null){

return "redirect:/admin/login";

}

projectRepository.deleteById(id);

System.out.println("Project Deleted Successfully!");

return "redirect:/admin/dashboard";

}
}