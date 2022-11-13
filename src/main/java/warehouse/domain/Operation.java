package warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "operation_number")
    private Long operationNumber;

    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "warehouse_from")
    private Long warehouseFrom;

    @Column(name = "warehouse_to")
    private Long warehouseTo;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;

    @OneToMany(
            mappedBy = "operation",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OperationItems> operations = new ArrayList<>();
}
