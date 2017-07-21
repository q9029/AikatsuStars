package com.github.q9029.starstrade.controller.bean;

import java.util.List;

import com.github.q9029.starstrade.repository.dto.BrandDto;
import com.github.q9029.starstrade.repository.dto.CardDto;
import com.github.q9029.starstrade.repository.dto.CategoryDto;
import com.github.q9029.starstrade.repository.dto.RarerityDto;
import com.github.q9029.starstrade.repository.dto.TypeDto;
import com.github.q9029.starstrade.repository.dto.VolumeDto;

public class SearchFormBean {

	// 値域
	private List<VolumeDto> volumeList;
	private List<TypeDto> typeList;
	private List<CategoryDto> categoryList;
	private List<BrandDto> brandList;
	private List<RarerityDto> rarityList;

	// 条件
	private String keyword;
	private Integer volume;
	private Integer type;
	private Integer category;
	private Integer brand;
	private Integer rarerity;

	// 結果
	private List<CardDto> cardList;

	public List<VolumeDto> getVolumeList() {
		return volumeList;
	}
	public void setVolumeList(List<VolumeDto> volumeList) {
		this.volumeList = volumeList;
	}
	public List<TypeDto> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<TypeDto> typeList) {
		this.typeList = typeList;
	}
	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}
	public List<BrandDto> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<BrandDto> brandList) {
		this.brandList = brandList;
	}
	public List<RarerityDto> getRarityList() {
		return rarityList;
	}
	public void setRarityList(List<RarerityDto> rarityList) {
		this.rarityList = rarityList;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getBrand() {
		return brand;
	}
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	public Integer getRarerity() {
		return rarerity;
	}
	public void setRarerity(Integer rarerity) {
		this.rarerity = rarerity;
	}
	public List<CardDto> getCardList() {
		return cardList;
	}
	public void setCardList(List<CardDto> cardList) {
		this.cardList = cardList;
	}
}
