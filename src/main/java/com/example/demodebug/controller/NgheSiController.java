package com.example.demodebug.controller;

import com.example.demodebug.model.NgheSi;
import com.example.demodebug.service.NgheSiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/demo")
public class NgheSiController {
    NgheSiService ngheSiService = new NgheSiService();

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", ngheSiService.getAll());
        return "demo/hien-thi";
    }

    @GetMapping("/add")
    public String showFormAdd() {
        return "demo/add";
    }

    @PostMapping("/add")
    public String addNgheSi(NgheSi ngheSi) {
        ngheSiService.addNgheSi(ngheSi);
        return "redirect:/demo/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("ngheSi", ngheSiService.findNgheSiById(id));
        return "demo/update";
    }

    @PostMapping("/update")
    public String updateNgheSi(NgheSi ngheSi) {
        ngheSiService.updateNgheSi(ngheSi);
        return "redirect:/demo/hien-thi";
    }

    @GetMapping("/delete")
    public String deleteNgheSi(@RequestParam("id") int id) {
        ngheSiService.deleteNgheSi(id);
        return "redirect:/demo/hien-thi";
    }

    @GetMapping("/search")
    public String searchNgheSi(@RequestParam("id") int id, Model model) {
        model.addAttribute("ngheSi", ngheSiService.findNgheSiById(id));
        return "demo/update";
    }
}

