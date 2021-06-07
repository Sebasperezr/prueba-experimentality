package com.perez.ptbackend.core.mappers;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class PasswordGenerator {

    public String generatePass() {
        return RandomStringUtils.random(15, true, true);
    }


}
