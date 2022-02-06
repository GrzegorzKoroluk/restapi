package pl.nullpointerexception.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.restapi.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTitle(String title);

    @Query("Select p From Post p" +
           " left join fetch p.comment")
    List<Post> findAllPosts(Pageable page);

//    @Query("select p from Post p where title = ?1")
//    List<Post> findAllByTitle(String title);

//    @Query("select p from Post p where title = :title")
//    List<Post> findAllByTitle(@Param("title") String title);
}
