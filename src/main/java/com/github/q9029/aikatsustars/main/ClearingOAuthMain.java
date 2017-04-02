package com.github.q9029.aikatsustars.main;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.q9029.aikatsustars.service.TwitterService;

public class ClearingOAuthMain {

    private static final Logger LOG = Logger.getLogger(ClearingOAuthMain.class);

    private static final int EXIT_NORMAL = 0;

    private static final int EXIT_ERROR = 1;

    public static void main(String[] args) {
        try {
            LOG.debug("バッチ処理を開始します。");

            // 処理開始時刻の取得
            long startTime = System.nanoTime();

            // Twitter連携のクリアリング処理
            // 連携が無効化されているアカウントはフラグを立てる
            // フラグが設定されたアカウントはフレンド検索で表示されないようにする
            try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
                TwitterService twitterService = context.getBean(TwitterService.class);
                twitterService.cleanAccounts();
              }

            // 処理終了時刻の取得
            long endTime = System.nanoTime();

            // ログ出力
            LOG.info("ProcessTime " + (endTime - startTime) + "ns");

            LOG.debug("バッチ処理を終了します。");
            System.exit(EXIT_NORMAL);

        } catch (Exception e) {
            LOG.error("バッチ処理で例外が発生しました。", e);
            System.exit(EXIT_ERROR);
        }
    }
}
