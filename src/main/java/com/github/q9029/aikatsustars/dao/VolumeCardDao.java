package com.github.q9029.aikatsustars.dao;

import java.util.List;

import com.github.q9029.aikatsustars.dto.VolumeCard;

public interface VolumeCardDao {

    List<VolumeCard> findAll();

    VolumeCard findById();
}
