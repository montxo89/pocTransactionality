package apaas.poc.microorch.facade;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Abstract service to be used as parent of the rest of service in the project.
 * 
 * 
 * @author accenture
 *
 */
public class AbstractFacade {

	static Logger logger = Logger.getLogger(AbstractFacade.class.getName());
	
  /**
   * Template to send http request.
   */
  private RestTemplate restTemplate;
  
  
  /**
   * Return a ResponseEntity object with HTTPStatus.OK
   * 
   * @param body
   *          object to be wrapped
   * @return the ResponseEntity
   */
  public ResponseEntity<HttpStatus> getResponseEntity(Object body) {
    return (new ResponseEntity<>(HttpStatus.OK));
  }

  /**
   * getForObject.
   * 
   * @param url
   *          to be requested
   * @param responseType
   *          Class to map the response
   * @return reponse
   */
  public <T> T getForObject(String url, Class<T> responseType) {
    URI uri = null;
    try {
      uri = new URI(url);
    } catch (Exception e) {
      String getForObjectLogger = String.format("Error al generar URI = %s", e.getMessage());
      logger.info(getForObjectLogger);
    }
    RestTemplate rest = new RestTemplate();
    return rest.getForObject(uri, responseType);
  }

  /**
   * PostForObject.
   * 
   * @param url
   *          to be requested
   * @param request
   *          body of the request
   * @param responseType
   *          to map the response
   * @return the response
   */
  public <T> T postForObject(String url, Object request, Class<T> responseType) {
    URI uri = null;
    try {
      uri = new URI(url);
    } catch (Exception e) {
      String postForObjectLogger = String.format("Error al generar URI = %s", e.getMessage());
      logger.info(postForObjectLogger);
    }
    RestTemplate rest = new RestTemplate();
    return rest.postForObject(uri, request, responseType);
  }

  /**
   * Exchange.
   * 
   * @param url
   *          to be requested
   * @param method
   *          to be used
   * @param requestEntity
   *          to be sent
   * @param responseType
   *          to map the response
   * @param uriVariables
   *          urivariables
   * @return response
   */
  public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
      Class<T> responseType, Object... uriVariables) {

	RestTemplate rest = new RestTemplate();
    return rest.exchange(url, method, requestEntity, responseType, uriVariables);
  }

  /**
   * PostForObject.
   * 
   * @param url
   *          to be requested
   * @param request
   *          body of the request
   * @param responseType
   *          to map the response
   * @return the response
   */
  public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType)
      throws URISyntaxException {
    URI uri = null;

    uri = new URI(url);

    return this.restTemplate.postForEntity(uri, request, responseType);
  }

}