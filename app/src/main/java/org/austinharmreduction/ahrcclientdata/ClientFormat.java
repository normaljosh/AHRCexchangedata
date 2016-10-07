package org.austinharmreduction.ahrcclientdata;

/**
 * Created by Josh Leibowitz on 9/5/2016.
 */

//structure of how client data for one client is stored
public class ClientFormat {
    private int id;
    private String date;
    private String staff;
    private String site;
    private String race;
    private String gender;
    private String age;
    private String needles_in;
    private String needles_out;
    private String type;
    private String ins;
    private String comment;
    public ClientFormat()
    {
    }
/*    //only for getting one client function, not used
    public ClientFormat(int id, String date, String staff, String site, String gender, String race,
                        String age, String needles_in, String needles_out, String type, String ins)
    {
        this.id=id;
        this.date=date;
        this.staff=staff;
        this.site=site;
        this.gender=gender;
        this.race=race;
        this.needles_in=needles_in;
        this.needles_out=needles_out;
        this.type=type;
        this.ins=ins;
    }*/
    //this is the stuff you enter from the buttons
    public ClientFormat( String staff, String site, String gender, String race,
                         String age, String needles_in, String needles_out, String type,
                         String ins, String comment)
    {

        this.staff=staff;
        this.site=site;
        this.gender=gender;
        this.age=age;
        this.race=race;
        this.needles_in=needles_in;
        this.needles_out=needles_out;
        this.type=type;
        this.ins=ins;
        this.comment=comment;
    }
    //functions to store button presses to a clientformat
    public void setid(int id){this.id = id;}
    public void setdate(String date){
        this.date = date;
    }
    public void setstaff(String staff){this.staff = staff;}
    public void setsite(String site){this.site = site;}
    public void setgender(String gender){this.gender = gender;}
    public void setrace(String race){
        this.race = race;
    }
    public void setage(String age){this.age = age;}
    public void setneedles_in(String needles_in){
        this.needles_in = needles_in;
    }
    public void setneedles_out(String needles_out){
        this.needles_out = needles_out;
    }
    public void settype(String type){this.type = type;}
    public void setins(String ins){this.ins = ins;}
    public void setcomment(String comment){this.comment = comment;}

//This lets me create an instance of a clientformat which can be called from any class
    private static final ClientFormat currentclient = new ClientFormat();
    public static ClientFormat getinstance() {return currentclient;}

    //functions to get the individual items from a clientformat
    public int getid() {
        return id;
    }
    public String getdate() {return date;}
    public String getstaff() {return staff;}
    public String getsite() {return site;}
    public String getgender() {
        return gender;
    }
    public String getrace() {
        return race;
    }
    public String getage() {return age;}
    public String  getneedles_in() {
        return needles_in;
    }
    public String getneedles_out() {
        return needles_out;
    }
    public String gettype() {return type;}
    public String getins() {return ins;}
    public String getcomment(){return comment;}
}