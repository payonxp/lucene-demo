package demo;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/lucene")
public class LuceneController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index(@RequestBody String req) {
        JSONObject json = new JSONObject(req);
        String path = json.getString("path");

        List list = Demo.index(path);

        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public String query(@RequestParam String keyword) throws Exception {

        List list = Demo.search(keyword);
        return new JSONObject(new RestResult(RetCode.SUCCESS.code, list)).toString();
    }

}


