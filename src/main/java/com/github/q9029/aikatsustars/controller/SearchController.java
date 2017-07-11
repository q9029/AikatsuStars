package com.github.q9029.aikatsustars.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.aikatsustars.controller.constant.RequestURI;
import com.github.q9029.aikatsustars.controller.constant.View;
import com.github.q9029.aikatsustars.form.Brand;
import com.github.q9029.aikatsustars.form.Category;
import com.github.q9029.aikatsustars.form.Rare;
import com.github.q9029.aikatsustars.form.Type;
import com.github.q9029.aikatsustars.form.Volume;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.SEARCH)
public class SearchController {

	private static final Logger LOG = Logger.getLogger(SearchController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpSession session) throws TwitterException {

		List<Brand> brandList = new ArrayList<>();
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("マイリトルハート");
		brandList.add(brand);
		request.setAttribute("brandList", brandList);

		List<Category> categoryList = new ArrayList<>();
		Category category = new Category();
		category.setId(0L);
		category.setName("トップス");
		categoryList.add(category);
		request.setAttribute("categoryList", categoryList);

		List<Rare> rareList = new ArrayList<>();
		Rare rare = new Rare();
		rare.setId(0L);
		rare.setName("PR");
		rareList.add(rare);
		request.setAttribute("rareList", rareList);

		List<Type> typeList = new ArrayList<>();
		Type type = new Type();
		type.setId(0L);
		type.setName("キュート");
		typeList.add(type);
		request.setAttribute("typeList", typeList);

		List<Volume> volumeList = new ArrayList<>();
		Volume volume = new Volume();
		volume.setId(0L);
		volume.setName("星のツバサ 1弾");
		volumeList.add(volume);
		request.setAttribute("volumeList", volumeList);

		return View.SEARCH;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpSession session) throws TwitterException {
		return "redirect:/search";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		LOG.error("System error.", e);
		return View.SEARCH;
	}
}
