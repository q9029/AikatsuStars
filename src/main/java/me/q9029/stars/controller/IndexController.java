package me.q9029.stars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import me.q9029.stars.controller.util.AuthUtil;
import me.q9029.stars.repository.model.NotificationEntity;
import me.q9029.stars.service.NotificationsService;

/**
 * Index(URI=/)コントローラ.
 * @author Queue
 */
@Controller
@RequestMapping("/")
public class IndexController extends AbstractController {

	@Autowired
	private NotificationsService service;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(WebRequest request) {

		// 更新情報の取得
		List<NotificationEntity> notificationList = service.getList();
		request.setAttribute("notificationList", notificationList, WebRequest.SCOPE_REQUEST);

		// すでに認証済みの場合
		if (AuthUtil.isAuthenticated(request)) {

		}

		return "index";
	}
}
