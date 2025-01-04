package org.study.conferences.virtual.threads;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class MainController {
    private final FakeHttpService fakeHttpService;

    public MainController(FakeHttpService fakeHttpService) {
        this.fakeHttpService = fakeHttpService;
    }

    @GetMapping("/speakers")
    List<Speaker> getSpeakers(){
        return fakeHttpService.retrieveSpeakers();
    }

    @GetMapping("/speakers-async")
    CompletableFuture<List<Speaker>> getSpeakersAsync(){
        return fakeHttpService.retrieveSpeakersAsync();
    }


}
