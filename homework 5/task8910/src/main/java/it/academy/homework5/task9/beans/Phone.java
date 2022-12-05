package it.academy.homework5.task9.beans;

@ContactAnnotated
public class Phone implements ContactInformation {
    private String phone;

    @Override
    public void setContact(String contact) {
        phone = contact;
    }

    @Override
    public String getContact() {
        return phone;
    }
}
