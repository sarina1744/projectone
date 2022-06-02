package com.revature.services;

import java.util.List;
import java.util.Optional;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Cart;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    public List<Cart> findAll();

    public Cart findById(int id);

    public Cart addCart(Cart c);

    public Cart update(Cart c);

    public boolean delete(int id);

    public String placeOrder();

    @Service
    class ItemServiceImpl implements ItemService{

        @Autowired
        private ItemRepository itemDAO;

        @Override
        public Optional<Item> findByItemName(String itemName) {
            return Optional.empty();
        }

        public List<Item> findAll() {
            return itemDAO.findAll();
        }

        public Item findById(int id) {
            return itemDAO.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(String.format("No item with id = %d", id)));
        }

        public Item addItem(Item i) {
            itemDAO.save(i);
            return i;
        }

        public Item update(Item i) {
            if (!itemDAO.existsById(i.getId())) {
                throw new RuntimeException("Item must already exist to update");
            }
            itemDAO.save(i);
            return i;
        }

        public boolean delete(int id) {
            if (!itemDAO.existsById(id)) {
                return false;
            }
            itemDAO.deleteById(id);
            return true;
        }
    }
}