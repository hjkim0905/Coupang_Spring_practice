package com.example.controller;

import com.example.controller.dto.ProductDto;
import com.example.controller.dto.ProductListDto;
import com.example.controller.form.AddProductForm;
import com.example.controller.form.EditProductForm;
import com.example.entity.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products/list")
    public String list(Model model) {
        model.addAttribute("products", ProductListDto.from(productService.getProducts()));
        return "list";
    }

    @GetMapping("/products/add")
    public String add() {
        return "add";
    }

    @PostMapping("/products/add")
    public String addOk(AddProductForm form,
                        @RequestParam MultipartFile image,
                        HttpServletRequest request) {
        productService.addProduct(form, image, request);
        return "redirect:/products/list";
    }

    @GetMapping("/products/{id}")
    public String view(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("product", ProductDto.from(productService.getProduct(id)));
        return "view";
    }

    @GetMapping("/products/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product product = productService.getProduct(id);
        EditProductForm form = EditProductForm.from(product);
        model.addAttribute("form", form);
        model.addAttribute("image", product.getImage());
        return "edit";
    }

    @PostMapping("/products/edit")
    public String editOk(@ModelAttribute("form") EditProductForm form, @RequestParam MultipartFile image, HttpServletRequest request) {
        productService.editProduct(form, image, request);
        return "redirect:/products/list";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products/list";
    }
}
