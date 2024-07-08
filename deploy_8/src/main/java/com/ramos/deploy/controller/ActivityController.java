package com.ramos.deploy.controller;

import com.ramos.deploy.model.Activity;
import com.ramos.deploy.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = {"http://localhost:8080", "http://your-frontend-domain.com"})
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/search")
    public List<Activity> searchActivities(@RequestParam String bangkasName) {
        return activityService.searchActivitiesByBangkasName(bangkasName);
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        int destinationPrice = activityService.getDestinationPrice(activity.getDestination());
        int bangkaPrice = activityService.getBangkaPrice(activity.getBangkasName());
        activity.setDate(new Date());
        activity.setTotalPrice(destinationPrice + bangkaPrice);
        return activityService.saveActivity(activity);
    }
}
