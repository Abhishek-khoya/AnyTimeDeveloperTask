package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name="college")
public class College {
    @Column(name = "college_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long collegeId;
    @Column(name="college_name")
    private String collegeName;
    @Column(name="city")
    private long city;
}
