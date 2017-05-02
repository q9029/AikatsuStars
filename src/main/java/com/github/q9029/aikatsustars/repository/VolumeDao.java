package com.github.q9029.aikatsustars.repository;

import java.io.Serializable;
import java.util.List;

import com.github.q9029.aikatsustars.dto.Volume;

public interface VolumeDao {

    Volume load(long id);

    Serializable save(Volume account);

    void delete(Volume account);

    List<Volume> loadAll();
}
