package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.Item;
import com.project.service.ItemService;


@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	// displays a list of items
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listItems", itemService.getAllItems());
		return "index";
	}
	@GetMapping("/NewItemForm")
	public String NewItemForm(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "newitem";
	}
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item item) {
		itemService.saveItem(item);
		return "redirect:/";
	}	
	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Item item = itemService.getItemById(id);

	        // sets item as a model to populate the form
	        model.addAttribute("item", item);
	        return "updateitem";
	    }

	    @GetMapping("/deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") long id) {

	        // calls the delete method for item
	        this.itemService.deleteItemById(id);
	        return "redirect:/";
	    }
}
