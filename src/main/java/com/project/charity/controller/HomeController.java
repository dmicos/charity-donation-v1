package com.project.charity.controller;

import com.project.charity.dto.EmailDto;
import com.project.charity.service.EmailService;
import com.project.charity.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final EmailService emailService;

    @GetMapping
    public String homeAction(Model model) {
        model.addAttribute("institutionsList", institutionService.getAll());
        return "index";
    }

    @GetMapping("/contact-us")
    public String showContactUs(Model model) {
        model.addAttribute("email", new EmailDto());
        return "contact-us";
    }

    @PostMapping("/contact-us")
    public String sendEmailContactUs(@ModelAttribute("email") @Valid EmailDto emailDto, BindingResult result) {
        if (result.hasErrors()) {
            return "contact-us";
        }
        emailService.sendUs(emailDto);
        return "redirect:/contact-us?success";
    }
}
