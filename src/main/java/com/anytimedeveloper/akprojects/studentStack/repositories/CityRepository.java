package com.anytimedeveloper.akprojects.studentStack.repositories;

import com.anytimedeveloper.akprojects.studentStack.pojos.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
    public Iterable<City> getCityByState(long id);
}
