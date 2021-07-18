package com.project.charity.controller;

import com.project.charity.domain.Role;
import com.project.charity.dto.PasswordDto;
import com.project.charity.dto.UserDto;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/default")
    public String defaultPageAfterLogin(HttpServletRequest request) {
        return request.isUserInRole("ADMIN") ? "redirect:/admin/users-list" : "redirect:/donation/list";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result,
                                      final HttpServletRequest request) {
        if (result.hasErrors()) {
            return "auth/registration";
        }
        userService.createUserAndSendConfirmationToken(userDto, Role.ROLE_USER, appUrlBuilder(request));
        return "redirect:/registration?success";
    }

    @GetMapping("/confirm-account")
    public String confirmRegistration(@RequestParam("token") String confirmationToken) {
        return userService.confirmUser(confirmationToken)
                ? "redirect:/login?confirmed"
                : "redirect:/login?invalidToken";
    }

    @GetMapping("/forgot-password")
    public String resetPassword() {
        return "auth/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String resetPassword(@RequestParam("email") String email,
                                final HttpServletRequest request) {
        return userService.sendPasswordResetToken(email, appUrlBuilder(request))
                ? "redirect:/forgot-password?success"
                : "redirect:/forgot-password?error";
    }

    @GetMapping("/change-password")
    public String showFormChangePassword(@RequestParam("token") String token, Model model) {
        if (!userService.existsPasswordResetToken(token)) {
            return "redirect:/login?invalidToken";
        }
        model.addAttribute("password", new PasswordDto());
        model.addAttribute("token", token);
        return "auth/change-password";
    }

    @PostMapping("/change-password")
    public String changePassword(@ModelAttribute("newPassword") @Valid PasswordDto passwordDto, BindingResult result,
                                 @ModelAttribute("token") String token) {
        if (result.hasErrors()) {
            return "change-password";
        }
        return userService.updateForgotPassword(passwordDto, token)
                ? "redirect:/login?success"
                : "redirect:/forgot-password?error";
    }

    private String appUrlBuilder(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
