package com.muyi.ec.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.muyi.ec.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {
	Optional<Tour> findByTitle(String title);
}
