package fr.crepin.microserviceuserbackend.enums;

import fr.crepin.microserviceuserbackend.dao.entity.LogementOptions;

public enum LogementOptionsEnum {
    WIFI, BATH, SHOWER, GARDEN, PRIVATE_ROOM, KING_SIZE_BED;

    public LogementOptionsEnum getLogementOptionFromString(String option){
        try{
            return valueOf(option);
        }catch (Exception e){
            throw new IllegalArgumentException("Unable to parse the option");
        }
    }
}
