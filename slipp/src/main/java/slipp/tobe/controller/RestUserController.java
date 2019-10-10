package slipp.tobe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nextstep.mvc.tobe.JsonView;
import nextstep.mvc.tobe.ModelAndView;
import nextstep.mvc.tobe.View;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;
import nextstep.web.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import slipp.domain.User;
import slipp.support.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RestUserController {
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = DataBase.findUserById(userId);
        if (user == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }

        ModelAndView mav = new ModelAndView(new JsonView());
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public String post(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(req.getReader(), User.class);
        DataBase.addUser(user);
        return "redirect:/api/users?userId=" + user.getUserId();
    }
}
