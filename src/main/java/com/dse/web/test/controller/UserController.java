package com.dse.web.test.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.dse.service.api.baseplatform.inf.dubbo.fresh.DepartmentServiceDubboRpc;
import com.dse.service.api.baseplatform.inf.dubbo.fresh.UserServiceDubboRpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author subiao_zhou
 * @since 2019-01-17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

/*    @Reference
    private DubooUserService dubooUserService;*/
    @Reference
    private DepartmentServiceDubboRpc departmentServiceDubboRpc;

    @Reference
    private UserServiceDubboRpc userServiceDubboRpc;

    @RequestMapping("index")
    public Object index() throws Exception {
        logger.info("xx");
        /*return *//*dubooUserService.queryString()*//*null;*/
        return userServiceDubboRpc.listAllUser();
    }

}
