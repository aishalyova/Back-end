package uni_campus.uni_campus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni_campus.uni_campus.model.News;
import uni_campus.uni_campus.repository.NewsRepository;

import java.util.List;
import java.util.Optional;

/** @noinspection ALL*/
@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(int id) {
        return newsRepository.findById(id);
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(int id, News news) {
        if (newsRepository.existsById(id)) {
            news.setId(id);
            return newsRepository.save(news);
        } else {
            return null;
        }
    }

    public boolean deleteNews(int id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
