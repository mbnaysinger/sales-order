package br.org.order.api.v1.converter;

import br.org.order.api.v1.dto.AddressDTO;
import br.org.order.api.v1.dto.PersonDTO;
import br.org.order.domain.model.Address;
import br.org.order.domain.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter {

    public Person convert(PersonDTO dto) {
        return Person.builder()
                .withName(dto.getName())
                .withTaxpayerId(dto.getTaxpayerId())
                .withAddress(this.convert(dto.getAddress()))
                .withPhone(dto.getCompletePhoneNumber())
                .withEmail(dto.getEmail())
                .withGender(dto.getGender())
                .build();
    }

    public Address convert(AddressDTO dto) {
        return Address.builder()
                .withStreet(dto.getStreet())
                .withAddressNumber(dto.getAddressNumber())
                .withAddressLine2(dto.getAddressLine2())
                .withCityName(dto.getCityName())
                .withCityCode(dto.getCityCode())
                .withDistrict(dto.getDistrict())
                .withState(dto.getState())
                .build();
    }

    public PersonDTO convert(Person person) {
        var persondto = new PersonDTO();
        persondto.setEmail(person.getEmail());
        persondto.setGender(person.getGenderString());
        persondto.setName(person.getName());
        persondto.setPhoneNumber(person.getPhoneNumber());
        persondto.setPhoneNumberDDD(person.getPhoneAreaCode());
        persondto.setTaxpayerId(person.getTaxpayerId().getNumber());
        persondto.setAddress(convert(person.getAddress()));
        return persondto;
    }

    public AddressDTO convert(Address address) {
        var addressDto = new AddressDTO();
        addressDto.setStreet(address.getStreet());
        addressDto.setAddressNumber(address.getAddressNumber());
        addressDto.setAddressLine2(address.getAddressLine2());
        addressDto.setCityCode(address.getCityCode());
        addressDto.setCityName(address.getCityName());
        addressDto.setDistrict(address.getDistrict());
        addressDto.setState(address.getState());
        return addressDto;
    }
}
