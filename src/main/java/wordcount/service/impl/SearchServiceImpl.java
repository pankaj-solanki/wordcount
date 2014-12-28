/**
 * 
 */
package wordcount.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import wordcount.constants.Constants;
import wordcount.rest.domain.SearchRequest;
import wordcount.rest.domain.SearchResponse;
import wordcount.service.SearchService;
import wordcount.util.ConfigUtil;

/**
 * @author pankaj
 *
 */
@Service("searchService")
@DependsOn("configUtil")
public class SearchServiceImpl implements SearchService {

  private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

  private static Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

  static {
    try {
      loadWordCountMap();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  private static void loadWordCountMap() throws IOException {
    logger.info("Loading word count map.");
    System.out.println("Loading word count map.");
    String[] inputFiles = ConfigUtil.getPropertyValueArray(Constants.INPUT_FILES_PROPERTY);
    if (inputFiles != null) {
      for (String inputFile : inputFiles) {
        logger.info("Reading file " + inputFile);
        System.out.println("Reading file " + inputFile);
        InputStream inputStream = new ClassPathResource(inputFile).getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
          String[] words = line.toUpperCase().split(Constants.WORD_DELIMITER);
          for (String word : words) {
            Integer count = wordCountMap.get(word);
            if (count == null) {
              count = 0;
            }
            count++;
            wordCountMap.put(word, count);
          }
        }
        
        for(String word : wordCountMap.keySet()){
          System.out.println(word);          
        }

      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see wordcount.service.SearchService#getWordCount(wordcount.rest.domain.SearchRequest)
   */
  public SearchResponse getWordCount(SearchRequest request) {
    SearchResponse response = new SearchResponse();
    String searchWord = request.getQuery().toUpperCase();
    logger.info("Querying for " + searchWord);
    System.out.println("Querying for " + searchWord);
    Integer count = wordCountMap.get(searchWord);
    if (count == null) {
      count = wordCountMap.get(request.getQuery());
      if(count == null){
        count = 0;
      }
    }
    response.setCount(count);
    return response;
  }



}
