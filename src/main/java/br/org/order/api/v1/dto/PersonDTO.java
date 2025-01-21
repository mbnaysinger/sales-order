package br.org.order.api.v1.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonDTO {

    @NotBlank(message = "person.taxpayerId.required")
    private String taxpayerId;

    @NotBlank(message = "person.name.required")
    private String name;

    private String phoneNumberDDD;

    private String phoneNumber;

    private String email;

    @NotNull(message = "person.address.required")
    @Valid
    private AddressDTO address;

    @NotBlank(message = "person.gender.required")
    private String gender;

    public String getTaxpayerId() {
        return this.taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumberDDD() {
        return this.phoneNumberDDD;
    }

    public void setPhoneNumberDDD(String phoneNumberDDD) {
        this.phoneNumberDDD = phoneNumberDDD;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return this.address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompletePhoneNumber() {
        return null == this.getPhoneNumberDDD() || null == this.getPhoneNumber()
                ? null
                : this.getPhoneNumberDDD() + this.getPhoneNumber();
    }

    @Override
    public String toString() {
        return String.format(
                "PayerDTO [taxpayerId=%s, name=%s, phoneNumberDDD=%s, phoneNumber=%s, email=%s, address=%s]",
                this.taxpayerId, this.name, this.phoneNumberDDD, this.phoneNumber, this.email, this.address);
    }

}
