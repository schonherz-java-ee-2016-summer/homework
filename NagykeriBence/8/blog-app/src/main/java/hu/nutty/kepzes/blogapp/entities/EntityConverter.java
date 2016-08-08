package hu.nutty.kepzes.blogapp.entities;

/**
 * Created by Nutty on 2016.08.08..
 */
public interface EntityConverter<T> {
    T toDTO();
}
