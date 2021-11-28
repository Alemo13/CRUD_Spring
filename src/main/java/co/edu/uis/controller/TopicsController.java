package co.edu.uis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uis.model.Topic;
import co.edu.uis.service.TopicsService;

@RestController
public class TopicsController {
    
    @Autowired
    private TopicsService topicsService;

    @RequestMapping("/topics")
    public List<Topic> all_Topics() {
        return topicsService.getAllTopicList();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String id) {
        return topicsService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicsService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
        topicsService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable("id") String id) {
        topicsService.deleteTopic(id);
    }
}
