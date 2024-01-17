package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "state")
public class State {
    @Column(name="state_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long stateId;
    @Column(name="state_name")
    private String stateName;
    @Column(name="country")
    private long country;
}
