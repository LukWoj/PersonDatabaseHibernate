package pl.lukwoj.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukwoj.spring.model.Person;

@Repository//bean
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
