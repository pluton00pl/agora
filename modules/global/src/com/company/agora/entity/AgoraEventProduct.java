package com.company.agora.entity;

import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "AGORA_AGORA_EVENT_PRODUCT")
@Entity(name = "agora_AgoraEventProduct")
public class AgoraEventProduct extends BaseLongIdEntity implements HasUuid {
    private static final long serialVersionUID = -4882462755185943713L;

    @Column(name = "UUID")
    private UUID uuid;

    @ManyToMany
    @JoinTable(name = "AGORA_AGORA_EVENT_PRODUCT_AGORA_PRODUCT_LINK",
            joinColumns = @JoinColumn(name = "AGORA_EVENT_PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "AGORA_PRODUCT_ID"))
    private List<AgoraProduct> eventproductProductID;

    @JoinTable(name = "AGORA_AGORA_EVENT_PRODUCT_AGORA_EVENT_LINK",
            joinColumns = @JoinColumn(name = "AGORA_EVENT_PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "AGORA_EVENT_ID"))
    @ManyToMany
    private List<AgoraEvent> eventproductEventID;

    public List<AgoraEvent> getEventproductEventID() {
        return eventproductEventID;
    }

    public void setEventproductEventID(List<AgoraEvent> eventproductEventID) {
        this.eventproductEventID = eventproductEventID;
    }

    public List<AgoraProduct> getEventproductProductID() {
        return eventproductProductID;
    }

    public void setEventproductProductID(List<AgoraProduct> eventproductProductID) {
        this.eventproductProductID = eventproductProductID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}