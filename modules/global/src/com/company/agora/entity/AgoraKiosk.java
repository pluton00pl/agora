package com.company.agora.entity;

import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "AGORA_AGORA_KIOSK")
@Entity(name = "agora_AgoraKiosk")
public class AgoraKiosk extends BaseLongIdEntity implements HasUuid {
    private static final long serialVersionUID = 6842579111297839642L;

    @Column(name = "UUID")
    private UUID uuid;

    @NumberFormat(pattern = "$xxx.xx", decimalSeparator = ".")
    @NotNull
    @Column(name = "KIOSK_COST", nullable = false, precision = 2, scale = 2)
    @PositiveOrZero(message = "Kiosk cost must be greater than $0")
    @DecimalMax("2")
    private BigDecimal kioskCost;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AGORA_EVENT_ID_ID")
    private AgoraEvent kioskEventID;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @NotNull
    @JoinColumn(name = "KIOSK_ORGANISER_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User kioskOrganiserId;

    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @NotNull
    @JoinColumn(name = "KIOSK_MERCHANT_ID_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User kioskMerchantID;

    public BigDecimal getKioskCost() {
        return kioskCost;
    }

    public void setKioskCost(BigDecimal kioskCost) {
        this.kioskCost = kioskCost;
    }

    public User getKioskMerchantID() {
        return kioskMerchantID;
    }

    public void setKioskMerchantID(User kioskMerchantID) {
        this.kioskMerchantID = kioskMerchantID;
    }

    public User getKioskOrganiserId() {
        return kioskOrganiserId;
    }

    public void setKioskOrganiserId(User kioskOrganiserId) {
        this.kioskOrganiserId = kioskOrganiserId;
    }

    public AgoraEvent getKioskEventID() {
        return kioskEventID;
    }

    public void setKioskEventID(AgoraEvent kioskEventID) {
        this.kioskEventID = kioskEventID;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}