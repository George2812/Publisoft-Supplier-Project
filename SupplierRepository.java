package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Person;
import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource
public interface SupplierRepository extends JpaRepository<Supplier,Long> {


    List<Supplier> findByVatNumber(String vatNumber);
    List<Supplier> findByCompanyName(String companyName);


}
