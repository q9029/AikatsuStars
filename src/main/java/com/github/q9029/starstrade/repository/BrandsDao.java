package com.github.q9029.starstrade.repository;

import java.util.List;

import com.github.q9029.starstrade.repository.dto.BrandDto;

public interface BrandsDao {

	List<BrandDto> loadAll();
}
