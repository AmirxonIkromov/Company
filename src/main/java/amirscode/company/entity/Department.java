package amirscode.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
