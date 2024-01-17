package com.anytimedeveloper.akprojects.studentStack.repositories;

import com.anytimedeveloper.akprojects.studentStack.pojos.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Long> {
    public Iterable<College> getCollegeByCity(long id);
}
