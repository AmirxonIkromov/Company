package amirscode.company.model;

import lombok.Data;

@Data
public class WorkerDTO {

    private String name;

    private String phoneNumber;

    private Integer addressId;

    private Integer departmentId;
}
