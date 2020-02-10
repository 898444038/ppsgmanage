package com.ming.ppsg.admin.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ming.ppsg.admin.config.security.JwtAuthenticatioToken;
import com.ming.ppsg.admin.entity.SysUser;
import com.ming.ppsg.admin.service.SysUserService;
import com.ming.ppsg.admin.utils.PasswordUtils;
import com.ming.ppsg.admin.utils.SecurityUtils;
import com.ming.ppsg.admin.vo.LoginBean;
import com.ming.ppsg.tool.http.HttpResult;
import com.ming.ppsg.tool.io.IOUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@RestController
public class SysLoginController {

	@Resource
	private Producer producer;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private AuthenticationManager authenticationManager;

	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/admin/login")
	public HttpResult login(@RequestBody Map<String,Object> map, HttpServletRequest request) throws IOException {
		LoginBean loginBean = new LoginBean();
		loginBean.setAccount((String) map.get("account"));
		loginBean.setPassword((String) map.get("password"));

		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		//String captcha = loginBean.getCaptcha();
		System.out.println(loginBean);
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		/*Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(kaptcha == null){
			return HttpResult.error("验证码已失效");
		}*/
//		if(!captcha.equals(kaptcha)){
//			return HttpResult.error("验证码不正确");
//		}
		
		// 用户信息
		SysUser user = sysUserService.findByName(username);

		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}

		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
		return HttpResult.ok(token.getToken());
	}

}
