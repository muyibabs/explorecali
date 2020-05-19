package com.muyi.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muyi.ec.domain.Difficulty;
import com.muyi.ec.domain.Region;
import com.muyi.ec.domain.Tour;
import com.muyi.ec.domain.TourPackage;
import com.muyi.ec.repo.TourPackageRepository;
import com.muyi.ec.repo.TourRepository;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title title
     * @param description description
     * @param blurb blurb
     * @param price price
     * @param duration duration
     * @param bullets comma-separated bullets
     * @param keywords keywords
     * @param tourPackageName tour package name
     * @param difficulty difficulty
     * @param region region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
        		.orElseThrow(()->new RuntimeException("Tourpackage does not exist: "+tourPackageName));

        Tour tour = new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, difficulty, region);
        return tourRepository.save(tour);
    }

    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }

}