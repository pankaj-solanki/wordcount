/**
 * 
 */
package wordcount.rest.domain;

/**
 * @author pankaj
 *
 */
public class SearchRequest {

  private String query;

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return "SearchRequest [query=" + query + "]";
  }

}
