/**
 * 
 */
package wordcount.service;

import wordcount.rest.domain.SearchRequest;
import wordcount.rest.domain.SearchResponse;

/**
 * @author pankaj
 *
 */
public interface SearchService {

  /**
   * Searches word and returns its count.
   * 
   * @param request
   * @return SearchResponse
   */
  public SearchResponse getWordCount(SearchRequest request);

}
