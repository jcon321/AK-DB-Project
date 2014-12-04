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
@Entity(name = "npc_types")
public class Npc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "level")
    private Integer level;
    
    @Column(name = "race")
    private Integer race;
    
    @Column(name = "class")
    private Integer npcClass;
    
    @Column(name = "AC")
    private Integer AC;
    
    @Column(name = "hp")
    private Integer hp;
    
    @Column(name = "mana")
    private Integer mana;
    
    @Column(name = "STR")
    private Integer STR;
    
    @Column(name = "STA")
    private Integer STA;
    
    @Column(name = "AGI")
    private Integer AGI;
    
    @Column(name = "DEX")
    private Integer DEX;
    
    @Column(name = "_INT")
    private Integer INT;
    
    @Column(name = "WIS")
    private Integer WIS;
    
    @Column(name = "ATK")
    private Integer ATK;
    
    @Column(name = "mindmg")
    private Integer minDmg;
    
    @Column(name = "maxDmg")
    private Integer maxDmg;
    
    @Column(name = "runspeed")
    private Integer runSpeed;
    
    @Column(name = "attack_delay")
    private Integer attackDelay;
    
    @Column(name = "MR")
    private Integer MR;
    
    @Column(name = "FR")
    private Integer FR;
    
    @Column(name = "CR")
    private Integer CR;
    
    @Column(name = "DR")
    private Integer DR;
    
    @Column(name = "PR")
    private Integer PR;
    
    @Column(name = "see_invis")
    private boolean seeInvis;
    
    @Column(name = "see_invis_undead")
    private boolean seeInvisUndead;
    
    @Column(name = "see_improved_hide")
    private boolean seeImprovedHide;
    
    private Integer spawnChance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getNpcClass() {
        return npcClass;
    }

    public void setNpcClass(Integer npcClass) {
        this.npcClass = npcClass;
    }

    public Integer getAC() {
        return AC;
    }

    public void setAC(Integer AC) {
        this.AC = AC;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getSTR() {
        return STR;
    }

    public void setSTR(Integer STR) {
        this.STR = STR;
    }

    public Integer getSTA() {
        return STA;
    }

    public void setSTA(Integer STA) {
        this.STA = STA;
    }

    public Integer getAGI() {
        return AGI;
    }

    public void setAGI(Integer AGI) {
        this.AGI = AGI;
    }

    public Integer getDEX() {
        return DEX;
    }

    public void setDEX(Integer DEX) {
        this.DEX = DEX;
    }

    public Integer getINT() {
        return INT;
    }

    public void setINT(Integer INT) {
        this.INT = INT;
    }

    public Integer getWIS() {
        return WIS;
    }

    public void setWIS(Integer WIS) {
        this.WIS = WIS;
    }

    public Integer getATK() {
        return ATK;
    }

    public void setATK(Integer ATK) {
        this.ATK = ATK;
    }

    public Integer getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(Integer minDmg) {
        this.minDmg = minDmg;
    }

    public Integer getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(Integer maxDmg) {
        this.maxDmg = maxDmg;
    }

    public Integer getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(Integer runSpeed) {
        this.runSpeed = runSpeed;
    }

    public Integer getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(Integer attackDelay) {
        this.attackDelay = attackDelay;
    }

    public Integer getMR() {
        return MR;
    }

    public void setMR(Integer MR) {
        this.MR = MR;
    }

    public Integer getFR() {
        return FR;
    }

    public void setFR(Integer FR) {
        this.FR = FR;
    }

    public Integer getCR() {
        return CR;
    }

    public void setCR(Integer CR) {
        this.CR = CR;
    }

    public Integer getDR() {
        return DR;
    }

    public void setDR(Integer DR) {
        this.DR = DR;
    }

    public Integer getPR() {
        return PR;
    }

    public void setPR(Integer PR) {
        this.PR = PR;
    }

    public boolean isSeeInvis() {
        return seeInvis;
    }

    public void setSeeInvis(boolean seeInvis) {
        this.seeInvis = seeInvis;
    }

    public boolean isSeeInvisUndead() {
        return seeInvisUndead;
    }

    public void setSeeInvisUndead(boolean seeInvisUndead) {
        this.seeInvisUndead = seeInvisUndead;
    }

    public boolean isSeeImprovedHide() {
        return seeImprovedHide;
    }

    public void setSeeImprovedHide(boolean seeImprovedHide) {
        this.seeImprovedHide = seeImprovedHide;
    }

    public Integer getSpawnChance() {
        return spawnChance;
    }

    public void setSpawnChance(Integer spawnChance) {
        this.spawnChance = spawnChance;
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
        if (!(object instanceof Npc)) {
            return false;
        }
        Npc other = (Npc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Npc[ id=" + id + " ]";
    }

}
