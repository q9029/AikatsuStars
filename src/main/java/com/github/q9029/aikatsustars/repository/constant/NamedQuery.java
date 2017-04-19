package com.github.q9029.aikatsustars.repository.constant;

public class NamedQuery {

    private NamedQuery() {}

    public class Account {
        public static final String findAll = "Account.findAll";
        public static final String findById = "Account.findById";
    }

    public class Card {
        public static final String findAll = "Card.findAll";
        public static final String findById = "Card.findById";
    }

    public class Volume {
        public static final String findAll = "Volume.findAll";
        public static final String findById = "Volume.findById";
    }

    public class VolumeCard {
        public static final String findAll = "VolumeCard.findAll";
        public static final String findById = "VolumeCard.findById";
    }
}
