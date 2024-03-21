package me.ankanroychowdhury.retrofitbasic.services;

import me.ankanroychowdhury.retrofitbasic.entities.Todo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ITodoService {
    @GET("todos/{id}")
    Call<Todo> getTodoById(@Path("id") long todoId);
}
