package com.github.q9029.stars_trade.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.stars_trade.repository.dto.AccountDto;

public interface AccountsDao {

	AccountDto load(long id);

	Serializable save(AccountDto account);

	void update(AccountDto account);

	void delete(AccountDto account);

	List<AccountDto> loadAll();
}
