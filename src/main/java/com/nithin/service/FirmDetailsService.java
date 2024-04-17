package com.nithin.service;

import com.nithin.entity.FirmDetails;

import java.util.Optional;

public interface FirmDetailsService {

    FirmDetails saveFirmDetails(FirmDetails firmDetails);

    FirmDetails findFirmDetails(String id);
}
