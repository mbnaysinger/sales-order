package br.org.order.api.v1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDTO {

    @NotBlank(message = "address.street.required")
    private String street;

    @NotBlank(message = "address.addressNumber.required")
    private String addressNumber;

    private String addressLine2;

    @NotNull(message = "address.zipCode.required")
    private Integer zipCode;

    @NotBlank(message = "address.cityName.required")
    private String cityName;

    @NotBlank(message = "address.cityCode.required")
    @Size(max = 7, message = "address.cityCode.size")
    private String cityCode;

    @NotBlank(message = "address.district.required")
    private String district;

    @NotBlank(message = "address.state.required")
    private String state;

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressNumber() {
        return this.addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Integer getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format(
                "AddressDTO [street=%s, addressNumber=%s, addressLine2=%s, zipCode=%s, cityName=%s, cityCode=%s, district=%s, state=%s]",
                street, addressNumber, addressLine2, zipCode, cityName, cityCode, district, state);
    }

}
