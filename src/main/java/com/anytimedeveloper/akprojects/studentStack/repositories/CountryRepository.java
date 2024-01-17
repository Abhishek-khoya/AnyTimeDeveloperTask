package com.anytimedeveloper.akprojects.studentStack.repositories;

import com.anytimedeveloper.akprojects.studentStack.pojos.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
