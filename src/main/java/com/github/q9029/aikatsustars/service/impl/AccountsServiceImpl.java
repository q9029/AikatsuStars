package com.github.q9029.aikatsustars.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.q9029.aikatsustars.dto.Account;
import com.github.q9029.aikatsustars.repository.AccountsDao;
import com.github.q9029.aikatsustars.service.AccountsService;
import com.github.q9029.aikatsustars.service.TwitterService;

import twitter4j.TwitterException;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private TwitterService twitterService;

    @Autowired
    private AccountsDao accountsDao;

    @Override
    public Account load(long id) {
        return accountsDao.load(id);
    }

    @Override
    public void update(Account account) {
        accountsDao.update(account);
    }

    @Override
    public void verifyAll() {
        // アカウント全件取得
        List<Account> accountList = accountsDao.loadAll();

        // 取得したアカウント件数ループ
        for (Account account : accountList) {

            // アクセストークンの有効性チェック
            boolean isValid = true;
            try {
                twitterService.verify(account);

            } catch (TwitterException e) {
                isValid = false;
            }
            // 有効フラグを設定
            account.setValid(isValid);
        }
    }
}
