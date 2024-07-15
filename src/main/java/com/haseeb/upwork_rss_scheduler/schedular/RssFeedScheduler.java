package com.haseeb.upwork_rss_scheduler.schedular;

import com.haseeb.upwork_rss_scheduler.service.EmailService;
import com.haseeb.upwork_rss_scheduler.service.RssFeedService;
import com.sun.syndication.feed.synd.SyndEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RssFeedScheduler {

    private final Logger log = LoggerFactory.getLogger(RssFeedScheduler.class);


    @Autowired
    private RssFeedService rssFeedService;

    @Autowired
    private EmailService emailService;

    private Set<String> processedEntries = new HashSet<>();

    private boolean isFirstRun=true;


    @Scheduled(fixedRate = 60000)
    public void checkForNewEntries() {
        log.info("Checking for new RSS feed entries");
        try {
            List<SyndEntry> entries = rssFeedService.fetchFeed();

            if(entries.isEmpty()) {
                log.info("No new entries found");
                return;
            }

            if (isFirstRun) {
                log.info("First run, skipping email sending {}",entries.size());
                processedEntries.addAll(entries.stream().map(SyndEntry::getUri).collect(Collectors.toSet()));
                isFirstRun = false;
                return;
            }


            entries.stream()
                    .filter(entry -> !processedEntries.contains(entry.getUri()))
                    .peek(entry -> log.info("Processing entry: {}", entry.getUri()))
                    .forEach(entry -> {
                        emailService.sendEmail(entry.getTitle(), entry.getDescription().getValue(), entry.getLink());
                        processedEntries.add(entry.getUri());
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
