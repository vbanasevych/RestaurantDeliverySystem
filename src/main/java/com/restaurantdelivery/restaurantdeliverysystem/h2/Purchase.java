package com.restaurantdelivery.restaurantdeliverysystem.h2;
import java.time.LocalDateTime;
public class Purchase {
    private final long id;

    Purchase(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }


}
