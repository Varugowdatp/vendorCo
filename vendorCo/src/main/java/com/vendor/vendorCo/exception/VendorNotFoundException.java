// src/main/java/com/vendor/vendorCo/exception/VendorNotFoundException.java
package com.vendor.vendorCo.exception;

public class VendorNotFoundException extends RuntimeException {
    public VendorNotFoundException(String message) {
        super(message);
    }
}
