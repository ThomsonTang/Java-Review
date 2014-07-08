package threadmanagement;

import java.util.Date;

/**
 * Event class which have two fields.
 *
 * @author ThomsonTang
 * @version ${VERSION}
 * @date 7/2/14
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
