package com.project.charity.controller;

import com.project.charity.dto.DonationDto;
import com.project.charity.service.CategoryService;
import com.project.charity.service.DonationService;
import com.project.charity.service.InstitutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/donation")
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @GetMapping("/create")
    public String createDonation(Model model) {
        model.addAttribute("categoriesList", categoryService.getAll());
        model.addAttribute("institutionsList", institutionService.getAll());
        model.addAttribute("donation", new DonationDto());
        return "donation/donation";
    }

    @GetMapping("/list")
    public String showDonationsPageByPage(@PageableDefault(page = 0, size = 5)
                                          @SortDefault(sort = "createdOn", direction = Sort.Direction.DESC)
                                                  Pageable pageable,
                                          Model model) {

        Page<DonationDto> donationPage = donationService.getPaginatedByAuthenticatedUser(pageable);
        int totalPages = donationPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("donationPage", donationPage);
        return "donation/donation-list";
    }

    @PostMapping("/create")
    public String createDonation(@ModelAttribute("donation") @Valid DonationDto donationDto, BindingResult result) {
        if (result.hasErrors()) {
            return "/donation/create";
        }
        donationService.saveOrUpdate(donationDto);
        return "redirect:/donation/list";
    }

    @GetMapping("/details{id}")
    public String showDonationDetails(@RequestParam(value = "id", required = true) Long id, Model model) {
        model.addAttribute("donation", donationService.getDonation(id));
        return "donation/donation-details";
    }
}
