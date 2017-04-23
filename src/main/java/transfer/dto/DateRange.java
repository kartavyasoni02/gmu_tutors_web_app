package transfer.dto;

import java.util.Date;

/**
 * Created by Andrew on 4/23/2017.
 *
 * Wrapper class for a range of 2 dates
 */
public class DateRange {
    private Date begin;
    private Date end;

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
