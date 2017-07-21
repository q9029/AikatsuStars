package com.github.q9029.stars_trade.repository;

import java.util.List;

import com.github.q9029.stars_trade.repository.dto.BrandDto;

public interface BrandsDao {

	List<BrandDto> loadAll();
}
