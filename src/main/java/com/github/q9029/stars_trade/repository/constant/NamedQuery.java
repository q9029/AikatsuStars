package com.github.q9029.stars_trade.repository.constant;

public class NamedQuery {

	private NamedQuery() {}

	public class Account {
		public static final String loadAll = "AccountsDao.loadAll";
	}

	public class Card {
		public static final String loadAll = "CardsDao.loadAll";
	}

	public class Volume {
		public static final String loadAll = "VolumesDao.loadAll";
	}

	public class VolumeCard {
		public static final String loadAll = "VolumeCardsDao.loadAll";
	}

	public class SystemSettings {
		public static final String loadAll = "SystemSettingsDao.loadAll";
	}
}
