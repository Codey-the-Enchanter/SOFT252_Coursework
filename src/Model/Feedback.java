/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Matthew
 */
public class Feedback implements java.io.Serializable {
    private Integer rating = 0;
    private String comment = "";
    
    public Feedback(Integer rating, String comment)
    {
        if (rating > 9)
            rating = 9;
        else if (rating < 0)
            rating = 0;
        this.rating = rating;
        
        this.comment = comment;
    }
    
    @Override
    public String toString()
    {
        return this.getRating() + this.getComment();
    }
    
    /**
     * Set rating value for feedback. Value is clipped to the range 0-9
     * @param rating the rating value to be set.
     */
    public void setRating(Integer rating)
    {
        if (rating > 9)
            rating = 9;
        else if (rating < 0)
            rating = 0;
        this.rating = rating;
    }
    
    public Integer getRating()
    {
        return this.rating;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return this.comment;
    }
}
