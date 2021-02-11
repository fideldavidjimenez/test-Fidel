package co.practicalTestFidel.repository;

import co.practicalTestFidel.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

/*    @Query("select c from Encuesta c join fetch c.orderDetails d join fetch d.product p where c.customer = :customer and c.creationDate > :initialDate and c.creationDate < :finalDate")
    List<Encuesta> findOrdersByCreationDate(@Param("customer") Marca aCustomer, @Param("initialDate") Date aInitialDate, @Param("finalDate") Date aFinalDate);

    @Query("select MAX(c.id) from Encuesta c ")
    Integer getMaxIdOrder();

    @Query("select MAX(o.id) from OrderDetail o")
    Integer getMaxIdOrderDetail();*/
}
