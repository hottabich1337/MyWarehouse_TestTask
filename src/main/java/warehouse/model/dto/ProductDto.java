package warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    @NotNull(message = "Name should be not empty")
    @NotEmpty(message = "Should be not empty")
    private String name;
    @NotNull(message = "Article should be not empty")
    @Min(message = "Article can't be less or equal zero ", value = 0L)
    private Long article;
    private BigDecimal lastSellingPrice;
    private BigDecimal lastAdmissionPrice;
}
