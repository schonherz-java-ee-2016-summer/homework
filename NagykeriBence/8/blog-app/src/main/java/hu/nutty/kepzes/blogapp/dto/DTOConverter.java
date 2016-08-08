package hu.nutty.kepzes.blogapp.dto;

/**
 * Created by Nutty on 2016.08.08..
 */
public interface DTOConverter<T> {
    T toEntity();
}
