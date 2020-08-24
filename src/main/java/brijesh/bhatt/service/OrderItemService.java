package brijesh.bhatt.service;

import brijesh.bhatt.entity.OrderItem;
import brijesh.bhatt.exception.ItemNotFoundException;
import brijesh.bhatt.repository.OrderItemRepository;
import brijesh.bhatt.to.ItemTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderItemRepository itemRepository;

    public List<ItemTO> getAllOrderItems() {
        logger.info("getAllOrderItems is being called.");
        List items = new ArrayList();
        itemRepository.findAll().forEach(item -> items.add(mapEntityTO(item)));
        return items;
    }

    public ItemTO getAllOrderItemById(int id) {
        logger.info("getAllOrderItemById is being called.");
        Optional<OrderItem> result = itemRepository.findById(id);
        if (result.isPresent()) {
            return mapEntityTO(result.get());
        } else {
            throw new ItemNotFoundException(id);
        }
    }

    public ItemTO createItem(ItemTO itemTO) {
        OrderItem orderItem = itemRepository.save(mapTOEntity(itemTO));
        return mapEntityTO(orderItem);
    }

    public ItemTO update(ItemTO itemTO) {
        if (itemRepository.existsById(itemTO.getId())) {
            OrderItem dbItem = mapTOEntity(itemTO);
            dbItem.setId(itemTO.getId());
            OrderItem orderItem = itemRepository.save(dbItem);
            return mapEntityTO(orderItem);
        } else {
            throw new ItemNotFoundException(itemTO.getId());
        }
    }

    public int delete(int id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return id;
        } else {
            throw new ItemNotFoundException(id);
        }
    }

    private ItemTO mapEntityTO(OrderItem orderItem) {
        return new ItemTO(orderItem.getId(), orderItem.getProductCode(), orderItem.getProductName(), orderItem.getQuantity());
    }

    private OrderItem mapTOEntity(ItemTO to) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductCode(to.getCode());
        orderItem.setProductName(to.getName());
        orderItem.setQuantity(to.getQuantity());
        return orderItem;
    }

}
