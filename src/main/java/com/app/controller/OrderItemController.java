package com.app.controller;

import com.app.to.ItemTO;
import com.app.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/online")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping(path = "/items", produces = "application/json")
    public List<ItemTO> getItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping(path = "/items/{id}", produces = "application/json")
    public ItemTO getItemsById(@PathVariable("id") Integer id) {
        return orderItemService.getAllOrderItemById(id);
    }

    @PostMapping("/items")
    public ItemTO saveItem(@Valid @RequestBody ItemTO itemTO) {
        return orderItemService.createItem(itemTO);
    }

    @PutMapping("/items")
    public ItemTO updateItem(@Valid @RequestBody ItemTO itemTO) {
        return orderItemService.update(itemTO);
    }

    @DeleteMapping("/items/{id}")
    public int deleteItem(@PathVariable("id") Integer id) {
        return orderItemService.delete(id);
    }
}
