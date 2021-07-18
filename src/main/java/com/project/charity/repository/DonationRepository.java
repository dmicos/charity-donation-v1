package com.project.charity.repository;

import com.project.charity.domain.Donation;
import com.project.charity.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findDonationsByUser(User user, Pageable pageable);
}
