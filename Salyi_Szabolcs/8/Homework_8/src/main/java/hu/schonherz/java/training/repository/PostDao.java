package hu.schonherz.java.training.repository;

import hu.schonherz.java.training.pojo.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Home on 2016. 08. 03..
 */

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface PostDao extends JpaRepository<Post, Long>{

    //List<Post> getAllPost();

    //void addPost(String author, String title, String content);

    //Post getPostById(int id);


}
