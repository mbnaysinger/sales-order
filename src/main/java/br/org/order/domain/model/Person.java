package br.org.order.domain.model;

import br.org.fiergs.person.model.Phone;
import br.org.fiergs.person.model.TaxpayerId;

public class Person {
    private TaxpayerId taxpayerId;
    private String name;
    private Address address;
    private Phone phone;
    private String email;
    private Gender gender;

    private Person(Builder builder) {
        this.taxpayerId = builder.taxpayerId;
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
        this.gender = builder.gender;
    }

    public TaxpayerId getTaxpayerId() {
        return this.taxpayerId;
    }

    public String getTaxpayerIdAsString() {
        return null == this.taxpayerId ? null : this.taxpayerId.getNumber();
    }

    public String getName() {
        return this.name;
    }

    public Address getAddress() {
        return this.address;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getPhoneAreaCode() {
        return null == phone ? null : phone.getAreaCode();
    }

    public String getPhoneNumber() {
        return null == phone ? null : phone.getNumber();
    }

    public String getEmail() {
        return this.email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGenderString() {
        return null == gender
                ? null
                : gender.toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Person person) {
        return new Builder(person);
    }

    public static final class Builder {
        private TaxpayerId taxpayerId;
        private String name;
        private Address address;
        private Phone phone;
        private String email;
        private Gender gender;

        private Builder() {
        }

        private Builder(Person person) {
            this.taxpayerId = person.taxpayerId;
            this.name = person.name;
            this.address = person.address;
            this.phone = person.phone;
            this.email = person.email;
            this.gender = person.gender;
        }

        public Builder withTaxpayerId(String taxpayerId) {
            this.taxpayerId = null == taxpayerId
                    ? null
                    : TaxpayerId.of(taxpayerId);
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String areaCode, String number) {
            this.phone = null == areaCode || null == number
                    ? null
                    : Phone.of(areaCode + number);
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = null == phone
                    ? null
                    : Phone.of(phone);
            return this;
        }

        public Builder withPhone(Phone phone) {
            this.phone = phone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder withGender(String gender) {
            return withGender(null == gender
                    ? null
                    : Gender.valueOf(gender));
        }

        public Person build() {
            return new Person(this);
        }
    }

}
