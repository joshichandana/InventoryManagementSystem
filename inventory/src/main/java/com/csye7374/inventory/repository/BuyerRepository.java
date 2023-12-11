package com.csye7374.inventory.repository;

import com.csye7374.inventory.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {


    //C
    //Buyer save(Buyer buyer);

    //R
//	List<Buyer> findAll();

    //R by ID
    Optional<Buyer> findById(int id);

    //D
//	void delete(Buyer buyer);

    //	Buyer update(Buyer buyer);
    Optional<Buyer> findByCompanyName(String companyName);

//	boolean findBycompanyName(String companyName);

}
