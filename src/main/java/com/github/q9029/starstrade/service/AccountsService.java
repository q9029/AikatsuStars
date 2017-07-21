package com.github.q9029.starstrade.service;

import com.github.q9029.starstrade.repository.dto.AccountDto;

public interface AccountsService {

	/**
	 * アカウントを取得する.
	 * @param id
	 * @return
	 */
	AccountDto load(long id);

	/**
	 * アカウントを更新する.
	 * @param account
	 */
	void update(AccountDto account);

	/**
	 * 登録されているアカウントすべての有効性チェックを行う.
	 */
	void verifyAll();
}
