package com.project.charity.service.impl;


import com.project.charity.domain.Donation;
import com.project.charity.domain.User;
import com.project.charity.dto.DonationDto;
import com.project.charity.mapper.DonationMapper;
import com.project.charity.repository.DonationRepository;
import com.project.charity.service.DonationService;
import com.project.charity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;
    private final UserService userService;
    private final DonationMapper mapper;

    @Override
    public void saveOrUpdate(DonationDto donationDto) {
        Donation donation = mapper.toEntity(donationDto);
        donation.setUser(userService.getAuthenticatedUser());
        donationRepository.save(donation);
    }

    @Override
    public Page<DonationDto> getPaginatedByAuthenticatedUser(Pageable pageable) {
        User user = userService.getAuthenticatedUser();
        List<Donation> donations = donationRepository.findDonationsByUser(user, pageable);
        List<DonationDto> dtos = mapper.toDtoList(donations);
        return new PageImpl<DonationDto>(dtos, pageable, dtos.size());
    }

    @Override
    public DonationDto getDonation(Long id) {
        return mapper.toDto(donationRepository.getOne(id));
    }
}
