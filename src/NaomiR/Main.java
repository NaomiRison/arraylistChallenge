package NaomiR;

import java.util.Scanner;

public class Main {
private  static Scanner s =new Scanner(System.in);
 private  static  Mobilephone mobile= new Mobilephone(" 0039 330 4404");
    public static void main(String[] args) {
	// write your code here

       boolean quit= false;
        startPhone();
        printActions();
        while (!quit){
            System.out.println("\nEnter action: 6 to show available actions");
            int action= s.nextInt();
            s.nextLine();
            switch (action){

                case 0:
                    System.out.println("\n shutting down...");
                    quit=true;  //  press zer0  quit is true and program ends
                    break;
                case 1:
                    mobile.printContacts();
                    break;
                case  2:
                    addNew();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }



        }
    }

    private  static  void addNew(){
        System.out.println(" Enter new contact name :");
        String name=s.nextLine();
        // need to add in new number as well
        System.out.println(" Enter phone number ");
        String phone= s.nextLine();
// its Contacts.createrecord(name,phone) because its calling class
        // and static method. dont have to do the usual with creating an object
        Contacts object1=Contacts.createrecord(name,phone);
        if(mobile.addnew(object1)){

            System.out.println("new contact added name = "
                    + name +  ", phone = " + phone);
        } else{


            System.out.println(" cannot add "+ name + " already on file");
        }
    }
    private  static  void updateContact(){

        System.out.println(" Enter existing contact name :");
        String name= s.nextLine();
        // implemetn another version of query to accept name and return
        // contact record for that name
         Contacts existing= mobile.query(name);  // result stored in existng
        if( existing==null) {
            // if u dont find entry return null
            System.out.println(" contact not found ");
            return;
        }
        System.out.println(" Enter new contact name :");
        String newName=s.nextLine();
        System.out.println(" Enter new contact number");
        String newNumber= s.nextLine();
        Contacts newC=Contacts.createrecord(newName,newNumber);
        if( mobile.update(existing,newC)){

            System.out.println(" Succeessfully updated record");
        } else{

            System.out.println(" Error updating record");

        }

    }

    private  static  void removeContact() {

        System.out.println(" Enter existing contact name :");
        String name = s.nextLine();
        // implemetn another version of query to accept name and return
        // contact record for that name
        Contacts existing = mobile.query(name);  // result stored in existng
        if (existing == null) {
            // if u dont find entry return null
            System.out.println(" contact not found ");
            return;
        }
        if (mobile.remove(existing)){

            System.out.println(" successfully deleted");

        } else{


            System.out.println(" error deletinf contact");
        }
    }




    private  static  void startPhone(){

        System.out.println(" starting phone...");
    }



        private  static  void printActions() {

            System.out.println("\n availBLE actions: \npress");
            System.out.println("0 - to shut down\n"+
                    "1- print contacts \n"+
                    "2 to add a new contact\n" +
                    "3 - to update existing contact\n"+
                    "4- to remove an existing contact\n"+
                    "5- query of an existing contact exists\n"+
                    " 6 - to print a list of available actions.");
            System.out.println(" choose your action");
        }

    private  static  void queryContact() {

        System.out.println(" Enter existing contact name :");
        String name = s.nextLine();
        // implemetn another version of query to accept name and return
        // contact record for that name
        Contacts existing = mobile.query(name);  // result stored in existng
        if (existing == null) {
            // if u dont find entry return null
            System.out.println(" contact not found ");
            return;
        }
        System.out.println(" Name :" + existing.getName()+
        " phone number is "+  existing.getPhonenum());
    }


}

/*


output:


 starting phone...

 availBLE actions:
press
0 - to shut down
1- print contacts
2 to add a new contact
3 - to update existing contact
4- to remove an existing contact
5- query of an existing contact exists
 6 - to print a list of available actions.
 choose your action

Enter action: 6 to show available actions
1
 Contact list

Enter action: 6 to show available actions
2
 Enter new contact name :
tim
 Enter phone number
345 477 7854
new contact added name = tim, phone = 345 477 7854

Enter action: 6 to show available actions
1
 Contact list
1 . tim ->345 477 7854

Enter action: 6 to show available actions
2
 Enter new contact name :
mary
 Enter phone number
235 574 8532
new contact added name = mary, phone = 235 574 8532

Enter action: 6 to show available actions
2
 Enter new contact name :
edith
 Enter phone number
235 8765
new contact added name = edith, phone = 235 8765

Enter action: 6 to show available actions
1
 Contact list
1 . tim ->345 477 7854
2 . mary ->235 574 8532
3 . edith ->235 8765

Enter action: 6 to show available actions

6

 availBLE actions:
press
0 - to shut down
1- print contacts
2 to add a new contact
3 - to update existing contact
4- to remove an existing contact
5- query of an existing contact exists
 6 - to print a list of available actions.
 choose your action

Enter action: 6 to show available actions
5
 Enter existing contact name :
Tim
 contact not found

Enter action: 6 to show available actions
5
 Enter existing contact name :
tim
 Name :tim phone number is 345 477 7854

Enter action: 6 to show available actions
3
 Enter existing contact name :
mary
 Enter new contact name :
Derek
 Enter new contact number
357 864 9877
 Succeessfully updated record

Enter action: 6 to show available actions

1
 Contact list
1 . tim ->345 477 7854
2 . Derek ->357 864 9877
3 . edith ->235 8765

Enter action: 6 to show available actions
4
 Enter existing contact name :
edith
edith was deleted
 successfully deleted

Enter action: 6 to show available actions
1
 Contact list
1 . tim ->345 477 7854
2 . Derek ->357 864 9877

Enter action: 6 to show available actions
0

 shutting down...

Process finished with exit code 0

 */

