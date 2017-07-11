package com.github.q9029.aikatsustars.form;

import java.util.List;

public class SearchFormBean {

	// 検索条件設定
	private List<String> volumeList;
	private List<String> typeList;
	private List<String> categoryList;
	private List<String> brandList;
	private List<String> rarityList;

	// 検索条件
	private String keyword;
	private String volume;
	private String type;
	private String category;
	private String brand;
	private String rarerity;

	// 検索結果
	private List<String> cardList;
}
