package ru.skypro.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "cityId")
@Builder
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    @Column(name = "city_name", length = 168, nullable = false)
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private List<Employee> employeeList = new ArrayList<>();

    public City(String cityName) {
        this.cityName = cityName;
    }

    public void addEmployee(Employee employee) {
        employee.setCity(this);
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employee.setCity(null);
        employeeList.remove(employee);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + getCityId() +
                ", cityName='" + getCityName() +
                '}';
    }
}
