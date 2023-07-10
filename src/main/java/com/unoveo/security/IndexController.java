package com.unoveo.security;

import com.unoveo.userservices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    private UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("in get mapping of index");
        return "index";
    }

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model){
//        // create model object to store form data
//        UserDTO user = new UserDTO();
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//    @PostMapping("/register/save")
//    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
//                               BindingResult result,
//                               Model model){
//        User existingUser = userService.findUserByEmail(userDto.getEmail());
//
//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", userDto);
//            return "/register";
//        }
//
//        userService.saveUser(userDto);
//        return "redirect:/register?success";
//    }

}