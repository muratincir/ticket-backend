package com.ahabilet.services.concretes;

import com.ahabilet.models.Gender;
import com.ahabilet.repositories.GenderRepository;
import com.ahabilet.services.abstracts.GenderService;
import org.springframework.stereotype.Service;

@Service
public class GenderManager implements GenderService {

    private GenderRepository genderRepository;

    public GenderManager(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Gender getOneGender(Long genderId) {
        return genderRepository.findById(genderId).orElse(null);
    }
}
