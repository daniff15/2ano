package lab06.ex2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lab06.ex2.ContactsInterface;
import lab06.ex2.ContactsStorageInterface;

public class ContactsImplementation implements ContactsInterface {
    private List<Contact> contactos;

    public ContactsImplementation() {
        this.contactos = new ArrayList<>();
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store){
        this.contactos.addAll(store.loadContacts());
    }

    @Override
    public void saveAndClose(){

        if(contactos.size() == 0){
            return;
        }
        Scanner input = new Scanner(System.in);


        System.out.println("Insere o nome do ficheiro onde quer guardar os contactos - (passar path lab06/ex2/FilesTXTBinary/)");
        String file = input.nextLine(); 

        ContactsStorageInterface storageContact = new ContactStorageImplementation(new File(file));

        storageContact.saveContacts(contactos);

    }

    @Override
    public void saveAndClose(ContactsStorageInterface store){

        if (contactos.size() == 0){
            return;
        }

        store.saveContacts(contactos);

    }
    
    @Override
    public boolean exist(Contact contact){
        for (Contact contacto : contactos) {
            if(contacto.equals(contact)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Contact getByName(String name){
        for (Contact contacto : contactos) {
            if(contacto.getNome().equals(name)){
                return contacto;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact){
        if(exist(contact)){
            return false;
        }
        contactos.add(contact);
        return true;

    }

    @Override
    public boolean remove(Contact contact){
        if(!exist(contact)){
            return false;
        }
        contactos.remove(contact);
        return true;
    }
}
