package com.denilson;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    //constructor for MobilePhone class inits myNumber and creates an empty arraylist of contacts
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    //add a new contact- using a boolean to check if contact already exists
    public boolean addNewContact(Contact contact) {
        //if contact already exists
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        //added contact successfully
        myContacts.add(contact);
        System.out.println("Contact successfully added");
        return true;

    }

    //update a contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        //if not found
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found");
            return false;
        }

        //if found then update contact
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replace with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        //if not found
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);

    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber()
            );
        }
    }

}
