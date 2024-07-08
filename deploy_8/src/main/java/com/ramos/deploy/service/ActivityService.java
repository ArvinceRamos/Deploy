package com.ramos.deploy.service;

import com.ramos.deploy.model.Activity;
import com.ramos.deploy.model.BangkaPrice;
import com.ramos.deploy.model.DestinationPrice;
import com.ramos.deploy.repository.ActivityRepository;
import com.ramos.deploy.repository.BangkaPriceRepository;
import com.ramos.deploy.repository.DestinationPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DestinationPriceRepository destinationPriceRepository;

    @Autowired
    private BangkaPriceRepository bangkaPriceRepository;

    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public List<Activity> searchActivitiesByBangkasName(String bangkasName) {
        return activityRepository.findByBangkasNameContainingIgnoreCase(bangkasName);
    }

    public int getDestinationPrice(String destination) {
        DestinationPrice destinationPrice = destinationPriceRepository.findByDestination(destination);
        return destinationPrice != null ? destinationPrice.getPrice() : 0;
    }

    public int getBangkaPrice(String bangkasName) {
        BangkaPrice bangkaPrice = bangkaPriceRepository.findByBangkaName(bangkasName);
        return bangkaPrice != null ? bangkaPrice.getPrice() : 0;
    }
}
