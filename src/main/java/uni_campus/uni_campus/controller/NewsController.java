package uni_campus.uni_campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni_campus.uni_campus.model.News;
import uni_campus.uni_campus.service.NewsService;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable int id) {
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.createNews(news);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable int id, @RequestBody News news) {
        News updatedNews = newsService.updateNews(id, news);
        if (updatedNews != null) {
            return ResponseEntity.ok(updatedNews);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable int id) {
        boolean isDeleted = newsService.deleteNews(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
