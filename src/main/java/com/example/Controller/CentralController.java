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

/**
 * 球団情報を管理するコントローラークラスです。
 * 球団の一覧表示や詳細表示の処理を行います。
 * 
 * @Author Akihide Takahashi
 */
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
        if (central == null) {
            return "error/notFound";
        }
        model.addAttribute("central", central);
        return "detail";
    }
}
