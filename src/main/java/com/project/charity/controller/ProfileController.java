package com.project.charity.controller;

import com.project.charity.dto.PasswordDto;
import com.project.charity.dto.ProfileDto;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    @GetMapping("/edit")
    public String showEditFormProfile(Model model) {
        model.addAttribute("profile", userService.getProfileAuthenticatedUser());
        return "edit-profile";
    }

    @PostMapping("/edit")
    public String saveChangedProfile(@Valid @ModelAttribute("profile") ProfileDto profileDto, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-profile";
        }
        userService.updateProfile(profileDto);
        return "redirect:/profile/info";
    }

    @GetMapping("/info")
    public String showUserProfile(Model model) {
        model.addAttribute("profile", userService.getProfileAuthenticatedUser());
        return "profile";
    }

    @GetMapping("/change-password")
    public String showChangePassword(Model model) {
        model.addAttribute("password", new PasswordDto());
        return "auth/change-password";
    }

    @PostMapping("/change-password")
    public String saveChangedPassword(@ModelAttribute("password") @Valid PasswordDto passwordDto, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/change-password";
        }
        userService.updatePasswordAuthorizedUser(passwordDto.getPassword());
        return "redirect:/profile?success";
    }
}
