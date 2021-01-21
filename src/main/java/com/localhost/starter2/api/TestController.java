package com.localhost.starter2.api;

import com.localhost.starter2.dto.RequestDto;
import com.localhost.starter2.dto.ResponseDto;
import com.localhost.starter2.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping("/add")
    public ResponseDto add(@RequestBody RequestDto requestDto) {
        long result = testService.add(requestDto.getNum1(), requestDto.getNum2());
        return new ResponseDto(result);
    }
}
