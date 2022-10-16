package com.helbiz.helbizassignment.service;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.helbiz.helbizassignment.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class PhoneNumberService {

    public void validatePhoneNumber(Phonenumber.PhoneNumber number) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        if (!phoneNumberUtil.isValidNumber(number)) {
            throw new ValidationException("Phone number [" + number + "] is not valid");
        }
    }

    public Phonenumber.PhoneNumber parsePhoneNumber(String phoneNumber) {
        try {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            return phoneUtil.parse(phoneNumber, Locale.ENGLISH.toString());
        } catch (NumberParseException e) {
            throw new ValidationException("Phone number " + phoneNumber + " parsing failed", e);
        }
    }

    public String getPhoneNumberCountry(Phonenumber.PhoneNumber phoneNumber) {
        PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
        return geocoder.getDescriptionForNumber(phoneNumber, Locale.ENGLISH);
    }

}
