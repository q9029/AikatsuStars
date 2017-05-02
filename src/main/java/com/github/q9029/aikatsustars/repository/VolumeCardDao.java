package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.VolumeCard;

public interface VolumeCardDao {

    VolumeCard load(long id);

    Serializable save(VolumeCard account);

    void delete(VolumeCard account);

    List<VolumeCard> loadAll();
}
