package com.github.q9029.aikatsustars.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.github.q9029.aikatsustars.service.SystemSettingsService;
import com.github.q9029.aikatsustars.service.util.SystemSettingsUtil;

@Component
public class StartupServlet extends HttpServlet implements ApplicationContextAware {

	private static final Logger LOG = Logger.getLogger(SystemSettingsUtil.class);

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}

	@Override
	public void init() throws ServletException {
		try {
			SystemSettingsService systemSettingsService = applicationContext.getBean(SystemSettingsService.class);
			systemSettingsService.reload();
		} catch (Exception e) {
			LOG.fatal("システムの起動に失敗しました。", e);
			throw e;
		}
	}
}
