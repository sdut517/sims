package com.sims.controller;

import com.alibaba.fastjson.JSON;
import com.sims.pojo.MangerUrl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

	/**
	 * 进入主页面
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "login";
	}

	@RequestMapping("/page/index")
	public String index1(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String roleid = (String)session.getAttribute("roleid");
		String userid = (String)session.getAttribute("userid");
		model.addAttribute("roleid", roleid);
		model.addAttribute("userid", userid);
		return "index";
	}
	@RequestMapping("/page/order_add")
	public String order_add() {
		return "order_add";
	}
	@RequestMapping("/page/order_detail")
	public String order_detail() {
		return "order_detail";
	}
	@RequestMapping("/page/order_list")
	public String order_list() {
		return "order_list";
	}
	@RequestMapping("/page/order_list_admin")
	public String order_list_admin() {
		return "order_list_admin";
	}
	@RequestMapping("/page/order_update")
	public String order_update() {
		return "order_update";
	}
	@RequestMapping("/page/stuff_add")
	public String stuff_add() {
		return "stuff_add";
	}
	@RequestMapping("/page/stuff_list")
	public String stuff_list() {
		return "stuff_list";
	}
	@RequestMapping("/page/stuff_update")
	public String stuff_update() {
		return "stuff_update";
	}
	@RequestMapping("/page/damaged_add")
	public String damaged_add() {
		return "damaged_add";
	}
	@RequestMapping("/page/damaged_list")
	public String damaged_list() {
		return "damaged_list";
	}
	@RequestMapping("/page/damaged_update")
	public String damaged_update() {
		return "damaged_update";
	}
	@RequestMapping("/page/supplier_add")
	public String supplier_add() {
		return "supplier_add";
	}
	@RequestMapping("/page/supplier_list")
	public String supplier_list() {
		return "supplier_list";
	}
	@RequestMapping("/page/supplier_update")
	public String supplier_update() {
		return "supplier_update";
	}
	@RequestMapping("/page/type_add")
	public String type_add() {
		return "type_add";
	}
	@RequestMapping("/page/type_list")
	public String type_list() {
		return "type_list";
	}
	@RequestMapping("/page/type_update")
	public String type_update() {
		return "type_update";
	}
	@RequestMapping("/page/user_add")
	public String user_add() {
		return "user_add";
	}
	@RequestMapping("/page/user_info")
	public String user_info() {
		return "user_info";
	}
	@RequestMapping("/page/user_list")
	public String user_list() {
		return "user_list";
	}
	@RequestMapping("/page/user_password")
	public String user_password() {
		return "user_password";
	}
	@RequestMapping("/page/type_analyse")
	public String type_analyse() {
		return "type_analyse";
	}
	@RequestMapping("/page/stuff_analyse")
	public String stuff_analyse() {
		return "stuff_analyse";
	}
	@RequestMapping("/page/damaged_analyse")
	public String damaged_analyse() {
		return "damaged_analyse";
	}
	@RequestMapping("/page/order_analyse")
	public String order_analyse() {
		return "order_analyse";
	}
	@RequestMapping("/page/user_update")
	public String user_update() {
		return "user_update";
	}
	@RequestMapping("/page/supplier_analyse")
	public String supplier_analyse() {
		return "supplier_analyse";
	}

	@RequestMapping("/page/search")
	@ResponseBody
	public String search(HttpServletRequest request,
						 @RequestParam("text") String text) {
		HttpSession session = request.getSession();
		String roleid = (String)session.getAttribute("roleid");
		List<MangerUrl> mangerUrls = new ArrayList<MangerUrl>();
		mangerUrls.add(new MangerUrl("个人信息", "user_info"));
		if (roleid.equals("1")) {
			mangerUrls.add(new MangerUrl("人员列表", "user_list"));
			mangerUrls.add(new MangerUrl("增加人员信息", "user_add"));
			mangerUrls.add(new MangerUrl("货物类型列表", "type_list"));
			mangerUrls.add(new MangerUrl("增加货物类型信息", "type_add"));
			mangerUrls.add(new MangerUrl("货物类型分析", "type_analyse"));
			mangerUrls.add(new MangerUrl("供货商列表", "supplier_list"));
			mangerUrls.add(new MangerUrl("增加供货商信息", "supplier_add"));
			mangerUrls.add(new MangerUrl("供货商分析", "supplier_analyse"));
			mangerUrls.add(new MangerUrl("订单列表", "order_list_admin"));
			mangerUrls.add(new MangerUrl("增加订单信息", "order_add"));
			mangerUrls.add(new MangerUrl("订单分析", "order_analyse"));
			mangerUrls.add(new MangerUrl("家电库存列表", "stuff_list"));
			mangerUrls.add(new MangerUrl("增加家电库存信息", "stuff_add"));
			mangerUrls.add(new MangerUrl("家电库存分析", "stuff_analyse"));
			mangerUrls.add(new MangerUrl("家电库存列表", "damaged_list"));
			mangerUrls.add(new MangerUrl("增加家电库存信息", "damaged_add"));
			mangerUrls.add(new MangerUrl("家电库存分析", "damaged_analyse"));
		} else if (roleid.equals("2")) {
			mangerUrls.add(new MangerUrl("货物类型列表", "type_list"));
			mangerUrls.add(new MangerUrl("增加货物类型信息", "type_add"));
			mangerUrls.add(new MangerUrl("订单列表", "order_list"));
			mangerUrls.add(new MangerUrl("家电库存列表", "stuff_list"));
			mangerUrls.add(new MangerUrl("增加家电库存信息", "stuff_add"));
			mangerUrls.add(new MangerUrl("家电库存列表", "damaged_list"));
			mangerUrls.add(new MangerUrl("增加家电库存信息", "damaged_add"));
		} else {
			mangerUrls.add(new MangerUrl("订单列表", "order_list_admin"));
			mangerUrls.add(new MangerUrl("增加订单信息", "order_add"));
		}
		List<MangerUrl> resMs = new ArrayList<MangerUrl>();
		for(int i = 0; i < mangerUrls.size(); i++) {
			if (mangerUrls.get(i).getName().indexOf(text) > -1) {
				resMs.add(mangerUrls.get(i));
			}
		}
		return JSON.toJSONString(resMs);
	}

}

