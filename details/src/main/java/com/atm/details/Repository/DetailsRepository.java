package com.atm.details.Repository;

import com.atm.details.Entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {
    Details findByDetailsId(Long detailsId);
}
