package org.austinharmreduction.ahrcclientdata;

/**
 * Created by Josh Leibowitz on 10/1/2016.
 */
public class SiteHolder {
    private String sitehold;
    private String staffhold;
    public String getsitehold() {return sitehold;}
    public String getstaffhold() {return staffhold;}
    public void setsitehold(String sitehold) {this.sitehold = sitehold;}
    public void setstaffhold(String staffhold) {this.staffhold = staffhold;}
    private static final SiteHolder ourInstance = new SiteHolder();

    public static SiteHolder getInstance() {
        return ourInstance;
    }
}
