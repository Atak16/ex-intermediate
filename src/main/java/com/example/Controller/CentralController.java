package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Central;
import com.example.Service.CentralService;

@Controller
@RequestMapping("/central")
public class CentralController {

    @Autowired
    private CentralService service;

    @GetMapping("")
    public String index(Model model) {
        List<Central> list = service.findAll();
        model.addAttribute("teamList", list);
        return "team";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Central central = service.load(id);
        model.addAttribute("central", central);
        return "detail";
    }
}
