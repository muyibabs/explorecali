package com.muyi.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muyi.ec.domain.TourPackage;
import com.muyi.ec.repo.TourPackageRepository;

@Service
public class TourPackageService {
	
	@Autowired
	private TourPackageRepository tourPackageRepository;
	
	public TourPackage createTourPackage(String code, String name) {
		TourPackage tp = new TourPackage(code, name);
		return tourPackageRepository.findByName(name)
				.orElse(tourPackageRepository.save(tp));
	}
	
	public Iterable<TourPackage> lookup(){
		return tourPackageRepository.findAll();
	}
	
	public long total() {
		return tourPackageRepository.count();
	}

}
