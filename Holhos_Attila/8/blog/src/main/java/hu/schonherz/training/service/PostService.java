package hu.schonherz.training.service;

import hu.schonherz.training.vo.PostVo;
import java.util.List;

/**
 * Created by Attila on 2016.08.06..
 */
public interface PostService {

    PostVo getPostByID(Long id);

    List<PostVo> getAllPosts();

    void createPost(PostVo postVo);
}
