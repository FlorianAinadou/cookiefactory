package model;

import java.util.Date;

/**
 * @author Lydia BARAUKOVA
 */
public class CinemaTicket {
    private Date movieDate;

    public CinemaTicket(Date d) {
        movieDate = d;
    }

    public Date getMovieDate() {
        return movieDate;
    }
}
