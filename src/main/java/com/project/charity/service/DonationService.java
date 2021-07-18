package com.project.charity.service;

import com.project.charity.dto.DonationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonationService {
    void saveOrUpdate(DonationDto donationDto);

    Page<DonationDto> getPaginatedByAuthenticatedUser(Pageable pageable);

    DonationDto getDonation(Long id);
}
