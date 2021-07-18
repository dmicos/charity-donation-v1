package com.project.charity.controller;

import com.project.charity.dto.InstitutionDto;
import com.project.charity.service.InstitutionService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("admin/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    @GetMapping
    public String showInstitutions(Model model) {
        model.addAttribute("institutions", institutionService.getAll());
        return "admin/institutions";
    }

    @GetMapping("edit/{id}")
    public String editInstitution(@PathVariable(value = "id") Long id, Model model) throws NotFoundException {
        model.addAttribute("institution", institutionService.getById(id));
        return "admin/institutionForm";
    }

    @GetMapping("create")
    public String createInstitution(Model model) {
        model.addAttribute("institution", new InstitutionDto());
        return "admin/institutionForm";
    }

    @PostMapping("save")
    public String saveInstitution(@Valid @ModelAttribute("institution") InstitutionDto institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institutionForm";
        }
        institutionService.saveOrUpdate(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("delete/{id}")
    public String removeInstitution(@PathVariable(value = "id") Long id) {
        institutionService.delete(id);
        return "redirect:/admin/institutions";
    }
}
