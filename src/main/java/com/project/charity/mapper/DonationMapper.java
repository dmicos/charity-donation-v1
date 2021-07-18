package com.project.charity.mapper;

import com.project.charity.domain.Donation;
import com.project.charity.dto.DonationDto;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper extends AbstractMapper<Donation, DonationDto> {
    public DonationMapper() {
        super(Donation.class, DonationDto.class);
    }
}
