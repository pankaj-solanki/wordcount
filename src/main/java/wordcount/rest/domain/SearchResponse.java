/**
 * 
 */
package wordcount.rest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author pankaj
 *
 */
public class SearchResponse {

  @JsonInclude(Include.ALWAYS)
  private int count;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "SearchResponse [count=" + count + "]";
  }

}
