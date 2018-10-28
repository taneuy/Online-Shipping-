package sut.sa.g04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sut.sa.g04.entity.*;
import sut.sa.g04.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodOrderController {
    private Long sum = 0L;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private FoodBasketRepository foodBasketRepository;
    @Autowired private FoodMenuRepository foodMenuRepository;

    @Autowired private FoodOrderRepository foodOrderRepository;
    
    public FoodOrderController(FoodOrderRepository foodOrderRepository){
        this.foodOrderRepository = foodOrderRepository;
    }
    @GetMapping("/food/orders")
    public Collection<FoodOrder> FoodOrder() {
        return foodOrderRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/food/orders/new/{adder}")
    public FoodOrder newOrder(@PathVariable String adder) {
        FoodOrder newFoodOrder = new FoodOrder();
        Customer customerOrder = customerRepository.findByName(adder);
        newFoodOrder.setAdder(customerOrder);
        return  foodOrderRepository.save(newFoodOrder); 
    }
    @GetMapping("/food/orders/getdata/{orderId}")
    public Optional<FoodOrder> foodOrder(@PathVariable Long orderId) {
        Optional<FoodOrder> F = foodOrderRepository.findById(orderId);
        return F;
    }
    @PostMapping("/food/orders/addMenu/{idOrder}/{listMenus}")
    public Long addMenu(@PathVariable long idOrder, @PathVariable String[] listMenus) {

        FoodOrder order = foodOrderRepository.findByOrderId(idOrder);
        FoodMenu menu;
        Long sum = 0L;


        for (String menus : listMenus) {
            menu = foodMenuRepository.findByFoodMenuName(menus);
            Long A = menu.getFoodMenuPrice();
            sum = sum + A;


            FoodBasket newSet = new FoodBasket();
            newSet.setFoodmenu(menu);
            newSet.setOrderID(idOrder);
            foodBasketRepository.save(newSet);

            order.getListMenu().add(newSet);
        }
        System.out.println(sum);
        foodOrderRepository.save(order); 
        return  sum;

    }
    @GetMapping("/food/orders/sum")
    public Long sum(@PathVariable long idOrder, @PathVariable String[] listMenus){
        Long sum = this.sum;
        // System.out.println(sum);
        return  sum; 
        

    }

}
