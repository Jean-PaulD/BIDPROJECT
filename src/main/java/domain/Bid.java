package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

/**
 * Created by Jean-Paul D on 2017-08-07.
 */
public class Bid implements Serializable {

    private String id;
    private String username;
    private String itemID;
    private Timer bidTimer;
    //relationship
    private User user;
    private Item item;

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    private Bid(){}

    public Bid(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.itemID = builder.itemID;
        this.bidTimer = builder.bidTimer;
        this.user = builder.user;
        this.item = builder.item;
    }

    public static class Builder{


        private String id;
        private String username;
        private String itemID;
        private Timer bidTimer;
        private User user;
        private Item item;

        public Builder user(User value){
            this.user = value;
            return this;
        }

        public Builder item(Item value){
            this.item = value;
            return this;
        }

        public Builder id(String value){
            this.id = value;
            return this;
        }

        public Builder username(String value){
            this.username = value;
            return this;
        }

        public Builder itemID(String value){
            this.itemID = value;
            return this;
        }

        public Builder bidTimer(Timer value){
            this.bidTimer = value;
            return this;
        }

        public Bid build(){
            return new Bid(this);
        }
    }




    public String getid() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getItemID() {
        return itemID;
    }

    public Timer getBidTimer() {
        return bidTimer;
    }



}
