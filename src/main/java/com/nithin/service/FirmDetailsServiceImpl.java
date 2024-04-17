package com.nithin.service;

import com.nithin.entity.FirmDetails;
import com.nithin.repository.FirmDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FirmDetailsServiceImpl implements FirmDetailsService{

    @Autowired
    private FirmDetailsRepository firmDetailsRepository;

    @Override
    public FirmDetails saveFirmDetails(FirmDetails firmDetails) {
        return firmDetailsRepository.save(firmDetails);
    }

    @Override
    public FirmDetails findFirmDetails(String id) {
        return firmDetailsRepository.findById(Long.valueOf(id)).orElse(null);
    }
}
