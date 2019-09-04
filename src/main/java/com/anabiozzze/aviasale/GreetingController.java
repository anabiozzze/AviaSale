package com.anabiozzze.aviasale;

import com.anabiozzze.aviasale.domain.Client;
import com.anabiozzze.aviasale.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private ClientRepo repo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Client> clients = repo.findAll();
        model.put("clients", clients);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String nationality,
                      @RequestParam String sex, @RequestParam(name = "birthDate") @DateTimeFormat(pattern = "yyyy-MM-dd")
                                  Date birthDate, @RequestParam long passNumber, Map<String, Object> model) {
        // сохраняем данные, введенные пользователем
        Client client = new Client(firstName, lastName, nationality, sex, birthDate, passNumber);
        repo.save(client);

        // возвравщаем сохранённые данные
        Iterable<Client> clients = repo.findAll();
        model.put("clients", client);

        return "main";
    }

}
