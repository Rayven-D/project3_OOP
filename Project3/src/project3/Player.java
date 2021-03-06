/*
// Jeffrey Tessitore
// CS 2365 - Object-Oriented Programming
// Section 002
// Project 3
 */
package project3;
import java.util.*;

import java.util.ArrayList;

/**
 *
 * @author Jeffrey Tessitore
 */
public class Player {
    
    /**
     * a boolean containing if the player is a user or a CPU
     */
    private boolean user;
    
    protected static int numPlayers;
protected static ArrayList<Player> players;
protected static int playersAlive;
    
    /**
     * an int containing the number of arrows current player has
     */
    private int arrows;
    
    /**
     * and boolean containing if the player has the cheif's arrow
     */
    private boolean chiefArrow;

    /**
     * a boolean containing if the Player is alive (true) or dead (false)
     */
    private boolean alive;
    
    /**
     * an integer containing the Player's health
     */
    private int health;
    
    /**
     * an integer containing the Player's player number
     */
    private final int playerNum;
    
    /**
     * an Object of type Character containing the Player's Character
     */
    private Character character;
    
    /**
     * an object of type Role containing the PLayer's Role
     */
    private Role role;
    
    /**
     * a boolean type saying if they are a Zombie Master
     */
    private boolean zombieMaster;
    
    /**
     * a boolean type saying if they are a zombie
     */
    private boolean zombie;
    
    
    /***
     * Declare a new Player Object
     * @param playerNum - the player number of the Player
     * @param user - is this Player a user
     */
    public Player(int playerNum, boolean user) {
        this.playerNum = playerNum;
        this.user = user;
        this.arrows = 0;
        this.alive = true;
        this.zombieMaster = false;
        players = new ArrayList<Player>();
        if (this.playerNum > numPlayers)
            numPlayers = this.playerNum;
        players.add(this);
        playersAlive++;
    }
    
    public void setZombie(boolean b, int life){
        this.zombie = b;
        this.health = life;
        playersAlive--;
    }
    public boolean getZombie(){
        return zombie;
    }
    public void setZombieMaster(boolean b){
        if(role.getName().equalsIgnoreCase("renegade")){
            this.zombieMaster = b;
            this.health = this.character.gainLifePoints(10);
            this.zombie = false;//because player can still use abilities      
        }  
    }
    public boolean getZombieMaster(){
        return this.zombieMaster;
    }   
    
    public void setChiefArrow(boolean b){
        this.chiefArrow = b;
    }
    public boolean hasChiefArrow(){
        return chiefArrow;
    }
    /***
     * return the Player's player number
     * @return an integer containing the Player's number
     */
    public int getNum() {
        return playerNum;
    }
    
    /***
     * return the Player's health
     * @return an integer containing the Player's health
     */
    public int getHealth() {
        return health;
    }
    
    /***
     * set the Player's health
     * @param health - the integer value to set the Player's health to
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /***
     * return the Player's alive status
     * @return a boolean dictating whether the player is alive or dead
     */
    public boolean getStatus() {
        return alive;
    }
    
    /***
     * set the Player's alive status
     * @param alive - the boolean value containing whether the player is alive
     */
    public void setStatus(boolean alive) {
        this.alive = alive;
        if (!alive)
            playersAlive--;
    }
    
    /***
     * set the Player's character
     * @param c - the Object of type Character the Player will be using
     */
    public void setCharacter(Character c) {
        this.character = c;
        this.setHealth(c.getLifePoints());
    }
    
    /***
     * return the Player's character
     * @return an Object of type Character corresponding to the Player's character
     */
    public Character getCharacter() {
        return character;
    }
    
    public void setArrows(int arrows){
        this.arrows = arrows;
    }
    public int getArrows(){
        return this.arrows;
    }
    
    /* UPDATE THIS ASAP - Shreyesh */
    
    public void setRole(Role role){
        this.role = role;
    }
    
    public Role getRole(){
        return this.role;
    }
    
    public boolean isUser(){
        return this.user;
    }
}
