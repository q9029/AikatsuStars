package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.VolumeDto;

public interface VolumeDao {

    VolumeDto load(long id);

    Serializable save(VolumeDto account);

    void delete(VolumeDto account);

    List<VolumeDto> loadAll();
}
