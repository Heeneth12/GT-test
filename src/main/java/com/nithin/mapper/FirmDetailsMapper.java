package com.nithin.mapper;

import com.nithin.Data.FirmDetailsDTO;
import com.nithin.entity.FirmDetails;
import com.nithin.utility.FirmDetailsUtility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@Slf4j
public class FirmDetailsMapper {


    public FirmDetailsDTO firmDetailsTODto(FirmDetails firmDetails) {
        log.debug("MAP--->");
        FirmDetailsDTO firmDetailsDTO = new FirmDetailsDTO();
        firmDetailsDTO.setFirmId(firmDetails.getFirmId());
        firmDetailsDTO.setFirmName(firmDetails.getFirmName());
        firmDetailsDTO.setAddress(firmDetails.getAddress());
        firmDetailsDTO.setPhoneNumber(firmDetails.getPhoneNumber());
        log.debug("MAP--->END");
        return firmDetailsDTO;
    }


    public FirmDetails firmDetailsDTOtoEnity(FirmDetailsDTO firmDetailsDTO) {
        FirmDetails firmDetails= new FirmDetails();
        firmDetails.setFirmId(FirmDetailsUtility.generateFirmId());
        firmDetails.setFirmName(firmDetailsDTO.getFirmName());
        firmDetails.setAddress(firmDetailsDTO.getAddress());
        firmDetails.setPhoneNumber(firmDetailsDTO.getPhoneNumber());
        System.out.println("MAP<<<<<<>>>>>--->END");
        return firmDetails;
    }
}
