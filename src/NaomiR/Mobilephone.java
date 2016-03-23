package NaomiR;

import java.util.ArrayList;

/**
 * Created by nrris on 2/23/2016.
 */
public class Mobilephone {



        private String mynum;
        private ArrayList<Contacts> mycontacts;

        public Mobilephone(String mynum) {
            this.mynum = mynum;
            this.mycontacts = new ArrayList();
        }

        public boolean addnew(Contacts contacts) {
            if(this.findContact(contacts.getName()) >= 0) {    //this.findClassname ( object.getname())
                System.out.println(" Contact is already on file");
                return false;
            } else {
                this.mycontacts.add(contacts);
                return true;
            }
        }

        private int findContact(Contacts contacts) {
            return this.mycontacts.indexOf(contacts);
        }

        private int findContact(String ContactName) {
            for(int i = 0; i < this.mycontacts.size(); ++i) {
                Contacts contacts = (Contacts)this.mycontacts.get(i);
                if(contacts.getName().equals(ContactName)) {
                    return i;
                }
            }

            return -1;
        }

        public boolean update(Contacts oldContact, Contacts newContact) {
            int found = this.findContact(oldContact);
            if(found < 0) {
                System.out.println(oldContact.getName() + " was not found");
                return false;
            } else {
                this.mycontacts.set(found, newContact);
                return true;
            }
        }

        public String query(Contacts contacts) {
            if(findContact(contacts) >= 0){

                return  contacts.getName();
            }
            return  null;

        }
    // method  finds record that matches name
    // and return that contact
    public Contacts query(String name) {

        int position = findContact(name);
        if (position >= 0) {
            // if you found an entry or name
            // return the contact object thats that position in array

            return this.mycontacts.get(position);

        }
        return null;
    }

        public boolean remove(Contacts contacts) {
            int found = this.findContact(contacts);
            if(found < 0) {
                System.out.println(contacts.getName() + " was not found");
                return false;
            } else {
                this.mycontacts.remove(found);
                System.out.println(contacts.getName() + " was deleted");
                return true;
            }
        }

        public void printContacts() {
            System.out.println(" Contact list");

            for(int i = 0; i < this.mycontacts.size(); ++i) {
                System.out.println(i + 1 + " . " + ((Contacts)this.mycontacts.get(i)).getName() +
                        " ->" + ((Contacts)this.mycontacts.get(i)).getPhonenum());
            }

        }
    }



