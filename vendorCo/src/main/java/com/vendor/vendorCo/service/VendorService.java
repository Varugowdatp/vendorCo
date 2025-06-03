    package com.vendor.vendorCo.service;

    import com.vendor.vendorCo.model.Vendor;
    import com.vendor.vendorCo.repository.VendorRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public abstract class VendorService {
        @Autowired
        private VendorRepository vendorRepository;

        public Vendor addVendor(Vendor vendor) {
            return vendorRepository.save(vendor);
        }

        public List<Vendor> getAllVendors() {
            return vendorRepository.findAll();
        }

        public  Vendor getVendorById(Long id){
            return vendorRepository.findById(id).orElse(null);
        };



        public  Vendor saveVendor(Vendor vendor){
          return vendorRepository.save(vendor);
        };

        public   void deleteVendor(Long id){
            vendorRepository.deleteById(id);
        };
    }
