package com.github.q9029.aikatsustars.dao;

import java.util.List;

import com.github.q9029.aikatsustars.dto.Volume;

public interface VolumeDao {

    List<Volume> findAll();

    Volume findById();
}
