package com.sims.controller;

import com.alibaba.fastjson.JSON;
import com.sims.pojo.Damaged;
import com.sims.pojo.DamagedExample;
import com.sims.service.DamagedService;
import com.sims.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/damaged")
public class DamagedController {

	@Autowired
	private DamagedService damagedService;
	@Value("${file.path}")
	private String fileRootPath;

	/**
	 * 增加材料信息
	 * 
	 * @param damaged
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/damagedadd", produces = "text/html;charset=UTF-8")
	public String damagedadd(Damaged damaged) throws Exception {
		damaged.setId(UUIDUtil.getUUID());
		if (damagedService.insert(damaged) > 0) {
			return "1";
		}
		return "增加失败";
	}

	/**
	 * 材料列表
	 * 
	 * @return
	 */
	@RequestMapping(value="/damagedlist", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String damagedlist() {
		DamagedExample damagedExample = new DamagedExample();
		// 设置查询条件，材料未被删除的
//		damagedExample.createCriteria()
//				.andStateNotEqualTo(Constant.STUFF_STATE_2);
		return JSON.toJSONString(damagedService.selectByExample(damagedExample));
	}

	/**
	 * 进入修改材料信息页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findById")
	public ModelAndView findById(String id) {
		ModelAndView mv = new ModelAndView("damaged_update");
		mv.addObject("damaged", damagedService.selectByPrimaryKey(id));
		return mv;
	}

	@RequestMapping(value = "/findByIds", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findByIds(String id) {
		return JSON.toJSONString(damagedService.selectByPrimaryKey(id));
	}

	/**
	 * 修改材料信息
	 * 
	 * @param damaged
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/damagedupdate", produces = "text/html;charset=UTF-8")
	public String damagedupdate(Damaged damaged) throws Exception {
		if (damagedService.updateByPrimaryKeySelective(damaged) > 0) {
			return "1";
		}
		return "修改失败";
	}

	/**
	 * 删除材料信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deteteById", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deteteById(String id) {
//		Damaged damaged = damagedService.selectByPrimaryKey(id);
//		damaged.setState(Constant.STUFF_STATE_2);
		if (damagedService.deleteByPrimaryKey(id) > 0) {
			return "删除成功";
		}
		return "删除失败";
	}

	/**
	 * 批量删除材料信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deteteByIds", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deteteByIds(String[] ids) {
		if (ids.length > 0) {
			for (String id : ids) {
				damagedService.deleteByPrimaryKey(id);
			}
			return "删除成功";
		}
		return "删除失败";
	}

	/**
	 * 通过类别查询材料信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findByType", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findByType(String typeId) {
		// 构建查询条件，通过材料类别查询
		DamagedExample damagedExample = new DamagedExample();
		damagedExample.createCriteria().andTypeIdEqualTo(typeId);
		return JSON.toJSONString(damagedService.selectByExample(damagedExample));
	}

}
