package me.ankanroychowdhury.retrofitbasic.controllers;

import me.ankanroychowdhury.retrofitbasic.entities.Todo;
import me.ankanroychowdhury.retrofitbasic.services.ITodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Controller
public class TodoController {
    @GetMapping("/")
    public String viewTodo(Model model) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ITodoService todoService = retrofit.create(ITodoService.class);
        Todo todo = todoService.getTodoById(2).execute().body();

        model.addAttribute("userId", todo.getUserId());
        model.addAttribute("todoId", todo.getId());
        model.addAttribute("title", todo.getTitle());
        model.addAttribute("status", todo.isCompleted());

        return "index";
    }
}
