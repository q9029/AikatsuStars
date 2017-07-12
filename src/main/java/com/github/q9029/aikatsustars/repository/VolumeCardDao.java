package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.VolumeCardDto;

public interface VolumeCardDao {

    VolumeCardDto load(long id);

    Serializable save(VolumeCardDto account);

    void delete(VolumeCardDto account);

    List<VolumeCardDto> loadAll();
}
