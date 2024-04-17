package com.nithin.transformer;

import com.nithin.Data.FirmDetailsDTO;
import com.nithin.entity.FirmDetails;
import com.nithin.mapper.FirmDetailsMapper;
import com.nithin.service.FirmDetailsServiceImpl;
import com.nithin.utility.FirmDetailsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FirmDetailsTransformer {

    @Autowired
    private FirmDetailsServiceImpl firmDetailsService;
    @Autowired
    private FirmDetailsMapper firmDetailsMapper;

    public FirmDetails creteFirmDetails(FirmDetailsDTO firmDetailsDTO) {
        FirmDetails transformedFirmDetails=firmDetailsMapper.firmDetailsDTOtoEnity(firmDetailsDTO);
            return firmDetailsService.saveFirmDetails(transformedFirmDetails);
    }

//    @Cacheable(value = "firmDetailsCache", key = "#id")
    public FirmDetailsDTO getFirmDetails(String id) {
       FirmDetails firmDetails=firmDetailsService.findFirmDetails(id);
        FirmDetailsDTO transfirmDetailsDTO=firmDetailsMapper.firmDetailsTODto(firmDetails);
        return transfirmDetailsDTO;
    }
}
