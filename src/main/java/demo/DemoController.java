package demo;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class DemoController {
    @RequestMapping(value = "/")
    @ResponseBody
    public String hello() {
        return "index.html";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String req) {
        JSONObject json = new JSONObject(req);
        String path = json.getString("path");

        List list = Demo.index(path);

        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String query(@RequestBody String req) throws Exception {
        JSONObject json = new JSONObject(req);
        String keyword = json.getString("keyword");

        List list = Demo.search(keyword);
        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

}


