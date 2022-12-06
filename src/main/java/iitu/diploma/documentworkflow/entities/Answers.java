package iitu.diploma.documentworkflow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "d_answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "text")
    private String answText;

    @Column(name = "date_send")
    private Date dataSend;

    @Column(name = "par_row_id")
    private Long parDocId;
}
