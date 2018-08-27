package testoweJpa.jpatest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName (String a);
    List<Customer> findByFirstName (String a);
    List<Customer> findByFirstNameAndLastName (String a, String b);

    @Query("SELECT a FROM Customer a WHERE a.firstName=:first and a.lastName=:last")
    List<Customer> fetchCustomers(@Param("first") String first, @Param("last") String last);


//    CrudRepository
//    a. We can start our query method names with find...By, read...By, query...By, count...By, and get...By.
//         Before By we can add expression such as Distinct .
//        After By we need to add property names of our entity.
//    b. To get data on the basis of more than one property we can concatenate property names using And and Or while creating method names.
//    c. If we want to use completely custom name for our method, we can use @Query annotation to write query.


//    On top of the CrudRepository there is a PagingAndSortingRepository
//    https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html




//    JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
//    Their main functions are:
//            •	CrudRepository mainly provides CRUD functions.
//            •	PagingAndSortingRepository provides methods to do pagination and sorting records.
//            •	JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.



}