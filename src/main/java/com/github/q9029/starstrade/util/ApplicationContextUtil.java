package com.github.q9029.starstrade.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext appContext;

	private ApplicationContextUtil() {}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		appContext = context;
	}

	public static <E> E getComponent(Class<E> clazz) {
		return appContext.getBean(clazz);
	}
}
