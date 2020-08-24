package brijesh.bhatt.repository;

import brijesh.bhatt.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}
