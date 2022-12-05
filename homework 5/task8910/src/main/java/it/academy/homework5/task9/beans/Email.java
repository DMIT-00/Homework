package it.academy.homework5.task9.beans;

public class Email implements ContactInformation {
    String email;

    @Override
    public void setContact(String contact) {
        email = contact;
    }

    @Override
    public String getContact() {
        return email;
    }
}
