package iitu.diploma.documentworkflow.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private Long id;
    private String docType;
    private int num;
    private int stud_id;
    private int owner_id;
    private String status;

}
