/**
 * 
 */
package wordcount.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wordcount.rest.domain.SearchRequest;
import wordcount.rest.domain.SearchResponse;
import wordcount.service.SearchService;

/**
 * @author pankaj
 *
 */
@RestController
public class SearchController {

  private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

  @Autowired
  private SearchService searchService;

  @RequestMapping(consumes="text/html; charset=UTF-8", value="/search")
  public SearchResponse search(SearchRequest searchRequest) {
    logger.info("Search request received with query = " + searchRequest);
    System.out.println("Search request received with query = " + searchRequest);
    return searchService.getWordCount(searchRequest);
  }

}
