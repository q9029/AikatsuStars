package com.github.q9029.aikatsustars.repository.dto;

import java.sql.Timestamp;

public class VolumeCardDto {

    private Long id;
    private Long volumeId;
    private Long cardId;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getVolumeId() {
        return volumeId;
    }
    public void setVolumeId(Long volumeId) {
        this.volumeId = volumeId;
    }
    public Long getCardId() {
        return cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public Timestamp getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
