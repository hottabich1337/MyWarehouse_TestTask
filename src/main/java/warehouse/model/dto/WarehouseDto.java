package warehouse.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseDto {
    private Long id;
    @NotBlank(message = "Name should be not empty")
    private String name;
    private Map<String,Integer> maps;

    public WarehouseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
