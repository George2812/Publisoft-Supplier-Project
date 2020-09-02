package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.*;


//create a controller class to access Suppliers in database
@RestController
@RequestMapping("/suppliers")
public class MainController {


    // to get bean called supplierRepository and handle the data
    @Autowired
    private SupplierRepository supplierRepository;

    //Get all suppliers
    @GetMapping("/getAll")
    private List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

//    Get suppliers by company name
    @GetMapping(path = "/company/{companyName}")
    private List<Supplier> getSuppliersByCompanyName(@PathVariable("companyName") String companyName) {
        List<Supplier> suppliers = supplierRepository.findByCompanyName(companyName);
        return suppliers;
    }

    //Get Suppliers by VAT number
    @GetMapping(path = "/vatNumber/{vatNumber}")
    private List<Supplier> getSuppliersByVatNumber(@PathVariable("vatNumber") String vatNumber) {
        List<Supplier> suppliers = supplierRepository.findByVatNumber(vatNumber);
        return suppliers;
    }


    //Create Supplier
    @PostMapping("/create")
    private Supplier createSupplier(@Valid @RequestBody Supplier supplier) {

        return supplierRepository.save(supplier);
    }

    //Find Supplier by id and Update it's fields
    @PutMapping("/supplier/{id}")
    public ResponseEntity<Supplier> updateSupplier(
            @PathVariable(value = "id") Long supplierId, @Valid @RequestBody Supplier supplierDetails)
            throws ResourceNotFoundException {
        Supplier supplier =
                supplierRepository
                        .findById(supplierId)
                        .orElseThrow(() -> new ResourceNotFoundException("Supplier not found on :: " + supplierId));
        supplier.setAddress(supplierDetails.getAddress());
        supplier.setCity(supplierDetails.getCity());
        supplier.setCompanyName(supplierDetails.getCompanyName());
        supplier.setCountry(supplierDetails.getCountry());
        supplier.setFirstName(supplierDetails.getFirstName());
        supplier.setIrsOffice(supplierDetails.getIrsOffice());
        supplier.setLastName(supplierDetails.getLastName());
        supplier.setVatNumber(supplierDetails.getVatNumber());
        supplier.setZipCode(supplierDetails.getZipCode());
        final Supplier updatedSupplier = supplierRepository.save(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    //Find by id and delete Supplier
    @DeleteMapping("/supplier/{id}")
    public Map<String, Boolean> deleteSupplier(@PathVariable(value = "id") Long supplierId) throws Exception {
        Supplier supplier =
                supplierRepository
                        .findById(supplierId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + supplierId));
        supplierRepository.delete(supplier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}








