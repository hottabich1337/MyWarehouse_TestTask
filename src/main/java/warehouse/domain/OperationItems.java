package warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OperationItems")
@Table(name = "operation_items")
public class OperationItems implements Serializable {

    @EmbeddedId
    private OperationItemsId id = new OperationItemsId();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private Operation operation;


    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column
    private Integer count = 0;

    @Column
    private BigDecimal price ;

}
