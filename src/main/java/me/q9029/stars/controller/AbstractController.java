package me.q9029.stars.controller;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 抽象コントローラ.
 * @author Queue
 */
public abstract class AbstractController {

	protected static final Logger logger = Logger.getLogger(AbstractController.class);

	/**
	 * 既知例外でのレスポンス返却.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ServiceException.class)
	protected ResponseEntity<Object> handleException(ServiceException ex) {

		// エラーログ出力
		logger.error(ex.getMessage(), ex);
		logger.error("HTTPステータスコード：" + ex.getStatus());

		// レスポンス作成
		// TODO ヘッダー情報の確認
		return new ResponseEntity<>(ex.getStatus());
	}
}
