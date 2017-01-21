package org.austinharmreduction.ahrcclientdata;

import java.util.Calendar;

/**
 * Created by Josh Leibowitz on 10/1/2016.
 */
public class SiteHolder {
    //this is a singleton class, to retain info like site, date, and who's entering the data across
    //different views.
    private String sitehold;
    private String staffhold;
    private Calendar datehold;
    public String getsitehold() {return sitehold;}
    public String getstaffhold() {return staffhold;}
    public Calendar getdatehold() {return datehold;}
    public void setsitehold(String sitehold) {this.sitehold = sitehold;}
    public void setstaffhold(String staffhold) {this.staffhold = staffhold;}
    public void setdatehold(Calendar datehold) {this.datehold = datehold;}
    private static final SiteHolder ourInstance = new SiteHolder();

    public static SiteHolder getInstance() {
        return ourInstance;
    }
    private SiteHolder() {
        // Exists only to defeat instantiation.
    }
}
