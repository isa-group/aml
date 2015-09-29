package es.us.isa.classes;

import java.io.Serializable;

/**
 * Applied Software Engineering Research Group (ISA Group)
 * University of Sevilla, Spain
 *
 * @author Antonio Gamez <agamez2@us.es>
 * @version 1.0
 */

public class Bird implements Serializable {
    private static final long serialVersionUID = -3235538169360094210L;
    private String id;
    private String specie;
    private String place;
    private Float legDiameter;
    private Float wingSize;
    private Integer eggs;
    private Integer hatches;

    public Bird() {
    }

    public Bird(String id, String specie, String place, Float legDiameter, Float wingSize, Integer eggs, Integer hatches) {
        this.id = id;
        this.specie = specie;
        this.place = place;
        this.legDiameter = legDiameter;
        this.wingSize = wingSize;
        this.eggs = eggs;
        this.hatches = hatches;
    }

    public String getSpecie() {
        return this.specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Float getLegDiameter() {
        return this.legDiameter;
    }

    public void setLegDiameter(Float legDiameter) {
        this.legDiameter = legDiameter;
    }

    public Float getWingSize() {
        return this.wingSize;
    }

    public void setWingSize(Float wingSize) {
        this.wingSize = wingSize;
    }

    public Integer getEggs() {
        return this.eggs;
    }

    public void setEggs(Integer eggs) {
        this.eggs = eggs;
    }

    public Integer getHatches() {
        return this.hatches;
    }

    public void setHatches(Integer hatches) {
        this.hatches = hatches;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bird [specie=" + this.specie + ", place=" + this.place + ", legDiameter=" + this.legDiameter + ", wingSize=" + this.wingSize + ", eggs=" + this.eggs + ", hatches=" + this.hatches + ", id=" + this.id + "]";
    }
}