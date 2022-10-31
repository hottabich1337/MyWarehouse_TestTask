package warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import warehouse.domain.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> getAllByProductId(Long productId);
    List<Operation> getAllByWarehouseFromOrWarehouseTo(Long warehouseFrom, Long warehouseTo);

    @Query("SELECT o FROM Operation o where o.productId = ?2  AND (o.warehouseFrom = ?1 OR o.warehouseTo = ?1)")
    List<Operation> getAllByWarehouseAndProduct(Long warehouseId, Long productId );

    @Query("SELECT o FROM Operation o where (o.warehouseFrom = ?1 OR o.warehouseTo = ?1)")
    List<Operation> getAllByWarehouse(Long warehouseId);
}
