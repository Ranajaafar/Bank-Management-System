package ul.info.Bank.common.response;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Response class, every response has the first few fields fixed:
 * <ul>
 *  <li><strong>status:</strong> the status of the response, for example "SUCCESS"</li>
 *  <li><strong>code:</strong> the error code, we use this error code as it's more descriptive than the
 *  default
 *  error codes, example "ADMIN-003"</li>
 *  <li><strong>message:</strong> the message that comes with the error, in case of no error it will be
 *  "SUCCESS"</li>
 *  <h2>response:</h2> the response body, this will be an object created at the
 *  service level
 * </ul>
 * @param <T> Response Body Type
 */
@Data
@Accessors(chain = true)
public class BaseResponse<T> { //generic class
    private String status;
    private String code;
    private String message;
    private T response; //generic instance variable

}