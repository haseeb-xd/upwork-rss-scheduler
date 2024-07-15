package com.haseeb.upwork_rss_scheduler.service;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class RssFeedService {

    private final Logger log = LoggerFactory.getLogger(RssFeedService.class);

    @Value("${upwork.rss.feed.url}")
    private String rssFeedUrl;

    public List<SyndEntry> fetchFeed() throws Exception {
        log.debug("Fetching RSS feed from URL: {}", rssFeedUrl);

        URL feedSource = new URL(rssFeedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        return feed.getEntries();
    }
}