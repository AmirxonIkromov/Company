package amirscode.company.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String corpName;

    private String directorName;

   @OneToOne
   @JoinColumn(name = "address_id")
   private Address address;
}
