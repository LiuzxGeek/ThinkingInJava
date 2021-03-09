package com.java.thinking.data.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/*
*@author:liuxian
*@date:2018年10月24日
*/
public class TestFastJson {
	static JSONObject pkPropMessageVo = new JSONObject();

	public static void main(String[] args) {
		pkPropMessageVo.put("avatar", "http://test-fdfs.ihuajian.com/img/M00/00/24/rB9QBVtbB_-AT_8OAAVzdBMXMOg643.png");
		pkPropMessageVo.put("doc", "鄩望 送给 褶皱 1个火药");
		pkPropMessageVo.put("iconUrl",
				"http://test.yrmanage.ihuajian.com/uploads/user/gift/icon_url/5bcd8a83e8ac8.jpg");
		pkPropMessageVo.put("myAnchorUid", 90001608);
		pkPropMessageVo.put("nickName", "鄩望");
		pkPropMessageVo.put("num", 1);
		pkPropMessageVo.put("propId", 1172);
		pkPropMessageVo.put("propName", "火药");

		pkPropMessageVo.put("propSvgUrl",
				"http://test.yrmanage.ihuajian.com/uploads/user/gift/prop_svg_url/5bcef21d767ee.svga");
		pkPropMessageVo.put("sendComment", false);
		pkPropMessageVo.put("tarUid", 1172);
		pkPropMessageVo.put("uid", 90004097);
		MessageVo messageVo = getPkPropMessageVo();
		System.out.println(messageVo.toString());
	}

	public static MessageVo getPkPropMessageVo() {
		return JSON.parseObject(pkPropMessageVo.toJSONString(), MessageVo.class);
	}
}
