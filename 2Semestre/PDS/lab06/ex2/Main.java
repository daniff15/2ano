package lab06.ex2;
import java.io.File;
import java.util.List;
//Ficheiros têm de ser passados com o path lab06/ex2/FilesTXTBinary/ e apenas com um "." que correponde à extensão do ficheiro

public class Main {
    public static void main(String[] args) {
        ContactsImplementation contactManagment = new ContactsImplementation();

        File thisFile = new File("lab06/ex2/FilesTXTBinary/ex2Text.txt");
        ContactsStorageInterface storage = new ContactStorageImplementation(thisFile);

        contactManagment.openAndLoad(storage);

        System.out.println(contactManagment.getByName("Dani"));

        contactManagment.add(new Contact("Joaquim Pinto",9145671));
        System.out.println(contactManagment.getByName("Joaquim Pinto"));

        contactManagment.remove(contactManagment.getByName("Pedro Sobras"));
        System.out.println(contactManagment.exist(new Contact("Pedro Sobras",989898912)));

        ContactsStorageInterface storage2 = new ContactStorageImplementation(new File("lab06/ex2/FilesTXTBinary/ex2TextSaveandClose.txt"));
        contactManagment.saveAndClose(storage2);

        contactManagment.saveAndClose();
        
        ContactsImplementation contactManagment2 = new ContactsImplementation();

        File thisFile2 = new File("lab06/ex2/FilesTXTBinary/ex2Binary.bin");
        ContactsStorageInterface storage3 = new ContactStorageImplementation(thisFile2);

        contactManagment2.openAndLoad(storage3);

        System.out.println(contactManagment2.getByName("Carlos Carl"));

        contactManagment2.add(new Contact("Joaquim Pinto",9145671));
        System.out.println(contactManagment2.getByName("Joaquim Pinto"));

        contactManagment2.remove(contactManagment2.getByName("Zé Manel"));
        System.out.println(contactManagment2.exist(new Contact("Zé Manel",965567874)));

        ContactsStorageInterface storage4 = new ContactStorageImplementation(new File("lab06/ex2/FilesTXTBinary/ex2BinarySaveandClose"));
        contactManagment2.saveAndClose(storage4);
        contactManagment2.saveAndClose();
    
    }
}
