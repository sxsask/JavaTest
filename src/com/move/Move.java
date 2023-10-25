package com.move;

public class Move {
    private  int movieid;
    private String moviename;
    private String director;
    private String typeid;
    private String stardom;

    private String region;
    private String showtime;
    private String description;
    private String image;
    private String price;


    public Move() {
    }

    public Move(int moveid, String movename, String director, String typeid, String stardom, String region, String showtime, String description, String image, String price) {
        this.movieid = moveid;
        this.moviename = movename;
        this.director = director;
        this.typeid = typeid;
        this.stardom = stardom;
        this.region = region;
        this.showtime = showtime;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    /**
     * 获取
     * @return moveid
     */
    public int getMovieid() {
        return movieid;
    }

    /**
     * 设置
     * @param moveid
     */
    public void setMovieid(int moveid) {
        this.movieid = moveid;
    }

    /**
     * 获取
     * @return movename
     */
    public String getMoviename() {
        return moviename;
    }

    /**
     * 设置
     * @param movename
     */
    public void setMoviename(String movename) {
        this.moviename = movename;
    }

    /**
     * 获取
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取
     * @return typeid
     */
    public String getTypeid() {
        return typeid;
    }

    /**
     * 设置
     * @param typeid
     */
    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取
     * @return stardom
     */
    public String getStardom() {
        return stardom;
    }

    /**
     * 设置
     * @param stardom
     */
    public void setStardom(String stardom) {
        this.stardom = stardom;
    }

    /**
     * 获取
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取
     * @return showtime
     */
    public String getShowtime() {
        return showtime;
    }

    /**
     * 设置
     * @param showtime
     */
    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    public String toString() {
        return "Move{moveid = " + movieid + ", movename = " + moviename + ", director = " + director + ", typeid = " + typeid + ", stardom = " + stardom + ", region = " + region + ", showtime = " + showtime + ", description = " + description + ", image = " + image + ", price = " + price + "}";
    }
}
