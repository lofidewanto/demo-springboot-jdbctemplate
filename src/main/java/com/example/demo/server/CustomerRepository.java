package com.example.demo.server;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	@Query("select id, first_name, last_name from customers where upper(first_name) like '%' || upper(:name) || '%' ")
	List<Customer> findByName(@Param("name") String name);

}
