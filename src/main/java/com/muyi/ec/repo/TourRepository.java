package com.muyi.ec.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.muyi.ec.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {
	Optional<Tour> findByTitle(String title);
	List<Tour> findByTourPackageCodeAndRegion(String tpCode, String region);
	List<Tour> findByPriceLessThan(Integer maxPrice);
	List<Tour> findByDescriptionContains(String desc);
	List<Tour> findByTourPackageCode(@Param("code") String tpCode);
	
	@Query("Select t from Tour t where t.tourPackage.code=?1 and t.price<=?2")
	List<Tour> findByTpCodeAndMaxPrice(String tpCode, Integer maxPrice);
	
	//Above is same as
	List<Tour> findByTourPackageCodeAndPriceLessThan(String tpCode, Integer maxPrice);
	
	@Override
	@RestResource(exported = false)
	<S extends Tour> S save(S entity);
	
	@Override
	@RestResource(exported = false)
	<S extends Tour> Iterable<S> saveAll(Iterable<S> entities);
	
	@Override
	@RestResource(exported = false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported = false) 
	void delete(Tour entity);
	
	@Override
	@RestResource(exported = false)
	void deleteAll(Iterable<? extends Tour> entities);
	
	@Override
	@RestResource(exported = false)
	void deleteAll();
	
	
}
