package com.github.q9029.stars_trade.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.q9029.stars_trade.controller.constant.RequestURI;
import com.github.q9029.stars_trade.controller.constant.SessionKey;
import com.github.q9029.stars_trade.controller.constant.View;
import com.github.q9029.stars_trade.repository.dto.AccountDto;
import com.github.q9029.stars_trade.service.TwitterService;

import twitter4j.TwitterException;

@Controller
@RequestMapping(value = RequestURI.INDEX)
public class IndexController {

	@Autowired
	private TwitterService twitterService;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(HttpSession session) {

		// セッションからアカウント情報の取得
		AccountDto account = (AccountDto) session.getAttribute(SessionKey.ACCOUNT);

		// NULLでない場合
		if (account != null) {
			// 有効性チェック
			try {
				twitterService.verify(account);

			} catch (TwitterException e) {
				// 有効でない場合、セッションを破棄
				session.invalidate();
			}
		}
		// index.jspを返却
		return View.INDEX;
	}
}
