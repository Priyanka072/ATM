package com.atm.changePin.Repositroy;

import com.atm.changePin.entities.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRepository extends CrudRepository<Pin, Integer> {
}
