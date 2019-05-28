package techy.ap.dbapp.Model;

public class Booking {
    private int id;
    private String docsname;
    private String patname;
    private int phonenumber;
    private int date;
    private int time;

    public Booking(int id, String docsname, String patname,int phonenumber, int date, int time) {
        this.id = id;
        this.docsname = docsname;
        this.patname = patname;
        this.phonenumber = phonenumber;
        this.date = date;
        this.time = time;
    }

    public Booking() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocsname() {
        return docsname;
    }

    public void setDocsname(String docsname) {
        this.docsname = docsname;
    }

    public String getPatname() {
        return patname;
    }

    public void setPatname(String patname) {
        this.patname = patname;
    }


    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
