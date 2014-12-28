/**
 * 
 */
package wordcount.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

  private static final Logger logger = Logger.getLogger(SearchController.class);

  @Autowired
  private SearchService searchService;

  @RequestMapping(consumes = "*/*; charset=UTF-8", value = "/search")
  public SearchResponse search(SearchRequest searchRequest) {
    logger.info("Search request received with query = " + searchRequest);
    return searchService.getWordCount(searchRequest);
  }

}
