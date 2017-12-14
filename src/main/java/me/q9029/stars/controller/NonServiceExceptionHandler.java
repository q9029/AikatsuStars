package me.q9029.stars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 既知例外以外の例外ハンドラ.
 * @author Queue
 */
@Component
public class NonServiceExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = Logger.getLogger(NonServiceExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {

		// エラーログ出力
		logger.fatal(ex.getMessage(), ex);

		// セッション削除
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();
		}

		// レスポンス作成
		// TODO ヘッダー情報の確認
		ModelAndView model = new ModelAndView();
		model.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
		return model;
	}
}
