package org.austinharmreduction.ahrcclientdata;

/**
 * Created by Josh Leibowitz on 9/5/2016.
 */
public class ClientFormat {
    private int id;
    private String race;
    private String gender;
    private String needles_in;
    private String needles_out;
    public ClientFormat()
    {
    }
    public ClientFormat(int id, String race, String gender, String needles_in, String needles_out)
    {
        this.id=id;
        this.race=race;
        this.gender=gender;
        this.needles_in=needles_in;
        this.needles_out=needles_out;
    }
    public ClientFormat( String race, String gender, String needles_in, String needles_out)
    {
        this.race=race;
        this.gender=gender;
        this.needles_in=needles_in;
        this.needles_out=needles_out;
    }
    public ClientFormat( String race, String gender)
    {
        this.race=race;
        this.gender=gender;
    }

    public void setid(int id){
        this.id = id;
    }
    public void setrace(String race){
        this.race = race;
    }
    public void setgender(String gender){
        this.gender = gender;
    }
    public void setneedles_in(String needles_in){
        this.needles_in = needles_in;
    }
    public void setneedles_out(String needles_out){
        this.needles_out = needles_out;
    }
    public int getid() {
        return id;
    }
    public String getrace() {
        return race;
    }
    public String getgender() {
        return gender;
    }
    public String  getneedles_in() {
        return needles_in;
    }
    public String getneedles_out() {
        return needles_out;
    }
    
}
