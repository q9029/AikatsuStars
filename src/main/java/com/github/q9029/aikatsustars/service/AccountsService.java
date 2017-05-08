package com.github.q9029.aikatsustars.service;

import com.github.q9029.aikatsustars.dto.Account;

public interface AccountsService {

    /**
     * アカウントを取得する.
     * @param id
     * @return
     */
    Account load(long id);

    /**
     * アカウントを更新する.
     * @param account
     */
    void update(Account account);

    /**
     * 登録されているアカウントすべての有効性チェックを行う.
     */
    void verifyAll();
}
