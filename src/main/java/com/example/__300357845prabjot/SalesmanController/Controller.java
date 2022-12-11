package com.example.__300357845prabjot.SalesmanController;


import com.example.__300357845prabjot.entity.Salesman;
import com.example.__300357845prabjot.repositories.salesmanRepositories;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {

    @Autowired
    private salesmanRepositories sr;

    @GetMapping(path = "/index")
    public String salesman(Model model, @RequestParam(name="keyword",defaultValue =
       "") String keyword){
        List<Salesman> salesmen;
        if (keyword.isEmpty()) {
            salesmen = sr.findAll();
        } else {
            long key = Long.parseLong(keyword);
            salesmen = sr.findSalesmanById(key);
        }
        model.addAttribute("listSalesman", salesmen);
        return"home";

    }



    @GetMapping("/delete")
    public String del(Long id)
    {
        sr.deleteById(id);
        return "redirect:/index";
    }
    @GetMapping("/edit")
    public String edit(long id, Model model)
    {
        Salesman salesman = sr.findById(id).orElse(null);
        if(salesman == null) throw new RuntimeException("not");
        model.addAttribute("saleman",salesman );
        return "editing";

    }
    @PostMapping("/reg")
    public String reg(@ModelAttribute Salesman u)
    {
        sr.save(u);
        sr.findAll();
        return "home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Salesman salesman)
    {
        sr.save(salesman);
        sr.findAll();
        return "redirect:/index";

    }

}
