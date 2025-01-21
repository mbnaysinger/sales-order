package br.org.order.domain.model;

import org.apache.commons.lang3.StringUtils;

public class Address {
    private String addressNumber;
    private String street;
    private String addressLine2;
    private String cityName;
    private String cityCode;
    private String district;
    private String state;

    private Address(Builder builder) {
        this.addressNumber = builder.addressNumber;
        this.street = builder.street;
        this.addressLine2 = builder.addressLine2;
        this.cityName = builder.cityName;
        this.cityCode = builder.cityCode;
        this.district = builder.district;
        this.state = builder.state;
    }

    public String getAddressNumber() {
        return this.addressNumber;
    }

    public String getStreet() {
        return this.street;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getState() {
        return this.state;
    }

    public String getFormattedAddress() {
        return String.format("%s, %s", this.street, this.addressNumber);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Address address) {
        return new Builder(address);
    }

    public static final class Builder {
        private String addressNumber;
        private String street;
        private String addressLine2;
        private String cityName;
        private String cityCode;
        private String district;
        private String state;

        private Builder() {
        }

        private Builder(Address address) {
            this.addressNumber = address.addressNumber;
            this.street = address.street;
            this.addressLine2 = address.addressLine2;
            this.cityName = address.cityName;
            this.cityCode = address.cityCode;
            this.district = address.district;
            this.state = address.state;
        }

        public Builder withAddressNumber(String addressNumber) {
            this.addressNumber = addressNumber;
            return this;
        }

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder withCityCode(String cityCode) {
            this.cityCode = !StringUtils.isBlank(cityCode) && cityCode.length() > 5 ?
                    StringUtils.right(cityCode, 5) :
                    cityCode;
            return this;
        }

        public Builder withDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder withState(String state) {
            this.state = state;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

}
