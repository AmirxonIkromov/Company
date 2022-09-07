package amirscode.company.model;

import amirscode.company.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private String corpName;

    private String directorName;

    private String homeNumber;

    private String street;
}
