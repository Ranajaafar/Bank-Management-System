package ul.info.Bank.common.util;

import org.springframework.stereotype.Component;
import ul.info.Bank.common.response.BaseResponse;

@Component
public class ResponseFactory {
    private static ResponseFactory instance;
    private ResponseFactory(){}
    public static ResponseFactory getInstance(){
        if(instance==null) instance=new ResponseFactory();
        return instance;
    }
    public  <T> BaseResponse<T> success(T response) {
        return new BaseResponse<T>().setResponse(response).setCode("0").setMessage("Success").setStatus("SUCCESS");
    }

    public  BaseResponse fail(String status, String code, String message) {
        return new BaseResponse().setStatus(status).setCode(code).setMessage(message);
    }
}
