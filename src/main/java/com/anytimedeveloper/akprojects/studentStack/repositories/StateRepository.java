package com.anytimedeveloper.akprojects.studentStack.repositories;

import com.anytimedeveloper.akprojects.studentStack.pojos.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
    public Iterable<State> getStateByCountry(long id);
}
