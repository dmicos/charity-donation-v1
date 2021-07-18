package com.project.charity.controller;

import com.project.charity.domain.Role;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("admin/")
public class AdminsController {

    private final UserService userService;

    @GetMapping("users-list")
    public String showUsersWithRoleUser(Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdOn");
        model.addAttribute("users", userService.getUsersByRoles(Role.ROLE_USER, sort));
        return "admin/users-list";
    }

    @PostMapping("users/delete")
    public String deleteUser(@RequestParam(value = "userIds", required = false) List<Long> usersIds) {
        if (usersIds!=null){
            userService.deleteUsers(usersIds);
        }
        return "redirect:/admin/users-list";
    }

    @GetMapping("users/create")
    public String redirectToRegPage() {
        return "redirect:/registration";
    }


    @GetMapping("admins-list")
    public String showUsersWithRoleAdmin(Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdOn");
        model.addAttribute("admins", userService.getUsersByRoles(Role.ROLE_ADMIN, sort));
        return "admin/admins-list";
    }

    @PostMapping("admins/delete")
    public String deleteAdmin(@RequestParam Long id) {
        //todo
//        userService.deleteUsers(id);
        return "redirect:/admin/admins-list";
    }

    @GetMapping("add-admin")
    public String showUsersCheckList(Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdOn");
        model.addAttribute("users", userService.getUsersByRoles(Role.ROLE_USER, sort));
        return "admin/add-admin";
    }

    @PostMapping("add-admin")
    public String chengeRoleToAdmin(@RequestParam(value = "ids", required = false) List<Long> usersId) {
        if (usersId != null) {
            userService.updateUsersRole(usersId, Role.ROLE_ADMIN);
        }
        return "redirect:/admin/admins-list";
    }
}
