package amirscode.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull
    private String street;

    @NotNull
    private String homeNumber;
}
