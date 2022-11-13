package warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OperationItemsId implements Serializable {
    @Column(name = "operation_id")
    private Long operationId;

    @Column(name = "product_id")
    private Long productId;
}
