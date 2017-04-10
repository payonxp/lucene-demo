package demo;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String req) {
        JSONObject json = new JSONObject(req);
        String path = json.getString("path");

        List<String> list = Demo.index(path);

        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String query(@RequestBody String req) throws Exception {
        JSONObject json = new JSONObject(req);
        String keyword = json.getString("keyword");

        List<String> list = Demo.search(keyword);

        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

}


