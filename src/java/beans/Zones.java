/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jconner
 */
@Entity(name = "zone")
public class Zones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "long_name")
    private String longName;

    @Column(name = "zone_exp_multiplier")
    private double zoneExpMultiplier;

    @Column(name = "hotzone")
    private boolean hotZone;

    @Column(name = "min_level")
    private int minLevel;

    @Column(name = "safe_x")
    private double safeX;

    @Column(name = "safe_y")
    private double safeY;

    @Column(name = "safe_z")
    private double safeZ;

    @Column(name = "zoneidnumber")
    private int zoneIdNumber;

    @Column(name = "canbind")
    private boolean canBind;

    @Column(name = "cancombat")
    private boolean canCombat;

    @Column(name = "canlevitate")
    private boolean canLevitate;

    @Column(name = "castoutdoor")
    private boolean castOutdoor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public double getZoneExpMultiplier() {
        return zoneExpMultiplier;
    }

    public void setZoneExpMultiplier(double zoneExpMultiplier) {
        this.zoneExpMultiplier = zoneExpMultiplier;
    }

    public boolean isHotZone() {
        return hotZone;
    }

    public void setHotZone(boolean hotZone) {
        this.hotZone = hotZone;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public double getSafeX() {
        return safeX;
    }

    public void setSafeX(double safeX) {
        this.safeX = safeX;
    }

    public double getSafeY() {
        return safeY;
    }

    public void setSafeY(double safeY) {
        this.safeY = safeY;
    }

    public double getSafeZ() {
        return safeZ;
    }

    public void setSafeZ(double safeZ) {
        this.safeZ = safeZ;
    }

    public int getZoneIdNumber() {
        return zoneIdNumber;
    }

    public void setZoneIdNumber(int zoneIdNumber) {
        this.zoneIdNumber = zoneIdNumber;
    }

    public boolean isCanBind() {
        return canBind;
    }

    public void setCanBind(boolean canBind) {
        this.canBind = canBind;
    }

    public boolean isCanCombat() {
        return canCombat;
    }

    public void setCanCombat(boolean canCombat) {
        this.canCombat = canCombat;
    }

    public boolean isCanLevitate() {
        return canLevitate;
    }

    public void setCanLevitate(boolean canLevitate) {
        this.canLevitate = canLevitate;
    }

    public boolean isCastOutdoor() {
        return castOutdoor;
    }

    public void setCastOutdoor(boolean castOutdoor) {
        this.castOutdoor = castOutdoor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zones)) {
            return false;
        }
        Zones other = (Zones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Zone[ id=" + id + " ]";
    }

}
