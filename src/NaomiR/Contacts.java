package NaomiR;

/**
 * Created by nrris on 2/22/2016.
 */
public class Contacts {
    private  String name;
    private  String phonenum;

    public Contacts(String name, String phonenum) {
        this.name = name;
        this.phonenum=phonenum;
    }

    public String getName() {
        return name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    //method creates new record without creating a new obkect
    // static allows us to not have to create new object
    // this calls costructor to create a public contact record

    public  static Contacts createrecord( String name, String phonenum){
       // create a new record of name and # without using a
        // instance or object to call on from main
        return  new Contacts(name, phonenum);

    }
}
