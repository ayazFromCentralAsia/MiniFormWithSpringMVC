package com.example.MakeATaskFromChatGPT.Controller;

import com.example.MakeATaskFromChatGPT.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Welcome {
    List<Person> persons = new ArrayList<>();
    @GetMapping("/userForm")
    public String showForm(Model model) {
        Person person = new Person();
        model.addAttribute("user", person);
        return "userForm";
    }

    @PostMapping("/userForm")
    public void processForm(@ModelAttribute("user") Person person) {
        persons.add(person);
    }

    @GetMapping("/userresult")
    public String showResults(Model model) {
        model.addAttribute("persons", persons);
        int id = 0;
        model.addAttribute("id", id);
        return "UserResult";
    }
    @PostMapping("/userresult")
    public String deletProcessForm(@RequestParam("id") int id){
        persons.remove(id - 1);
        return "redirect:/userresult";
    }
}
