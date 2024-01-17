package com.anytimedeveloper.akprojects.studentStack.pojos;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name="city")
public class City {
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long cityId;
    @Column(name="city_name")
    private String cityName;
    @Column(name="state")
    private long state;
}
