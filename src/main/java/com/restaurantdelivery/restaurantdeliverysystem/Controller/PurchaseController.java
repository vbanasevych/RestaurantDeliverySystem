package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseRepository.findAll());
        return "purchase/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        return "purchase/form";
    }

    @PostMapping
    public String savePurchase(@ModelAttribute Purchase purchase) {
        purchaseRepository.save(purchase);
        return "redirect:/purchases";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Purchase purchase = purchaseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid purchase Id:" + id));
        model.addAttribute("purchase", purchase);
        return "purchase/form";
    }

    @GetMapping("/delete/{id}")
    public String deletePurchase(@PathVariable Long id) {
        purchaseRepository.deleteById(id);
        return "redirect:/purchases";
    }
}
