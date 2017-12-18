package me.q9029.stars.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import me.q9029.stars.controller.util.AuthUtil;

@Controller
@RequestMapping("/signout")
public class SignoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request, HttpSession session) {

		// 認証情報の確認
		boolean isAuthFlg = AuthUtil.isAuthenticated(request);

		// セッションの削除
		if (session != null) {
			session.invalidate();
		}

		// 認証情報が確認できない場合は404返却
		if (!isAuthFlg) {
			throw new ServiceException(HttpStatus.NOT_FOUND, "認証情報が確認できませんでした。");
		}

		return "redirect:/";
	}
}
