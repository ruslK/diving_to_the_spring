package com.ormmanytomany.bootstrap;

import com.ormmanytomany.entity.Post;
import com.ormmanytomany.entity.Tag;
import com.ormmanytomany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Generator implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        Post p1 = new Post("post1", "post1");
        Post p2 = new Post("post2", "post2");
        Post p3 = new Post("post3", "post3");

        Tag t1 = new Tag("tag1");
        Tag t2 = new Tag("tag2");
        Tag t3 = new Tag("tag3");

        p1.getTags().add(t1);
        p1.getTags().add(t2);
        p2.getTags().add(t3);

        t1.getPosts().add(p3);
//        t2.getPosts().add(p3);
//        t3.getPosts().add(p1);

        postRepository.save(p1);
        postRepository.save(p2);
    }
}
