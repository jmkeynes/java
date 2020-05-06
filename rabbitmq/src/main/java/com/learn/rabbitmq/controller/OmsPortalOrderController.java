package com.learn.rabbitmq.controller;

import com.learn.rabbitmq.dto.OrderParam;
import com.learn.rabbitmq.pojo.Result;
import com.learn.rabbitmq.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author：江文谱
 * @date： 2020/5/5 22:06
 * @version： 1.0
 */
@RestController
@Api(tags = "订单管理")
public class OmsPortalOrderController {


    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OmsPortalOrderService service;

    @ApiOperation(value = "根据购物车生成订单")
    @PostMapping("generateOrder")
    public Result generateOrder(@Valid @RequestBody OrderParam param, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            errors.forEach(fieldError -> {
                String message = fieldError.getDefaultMessage();
                String field = fieldError.getField();
                LOGGER.info("{}--->{}", field, message);
            });
            return Result.fialed(400, "提交的参数有误！！！");
        }
        return service.generateOrder(param);
    }
}
