package com.java.thinking.data.json;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

/*
*@author:liuxian
*@date:2019年6月20日
*/
public class TestJson2Object {
	private static String result = "{" + "	\"code\": 0," + "	\"message\": \"SUCCESS\"," + "	\"data\": {"
			+ "		\"list\": [\"{\\\"fromNick\\\":\\\"1号主播\\\",\\\"msgType\\\":\\\"CUSTOM\\\",\\\"fromExt\\\":\\\"{\\\\\\\"sex\\\\\\\":1}\\\",\\\"fromAvator\\\":\\\"http://fdfs-uat.tyi365.com/img/M00/00/4D/rB9QBVwt226AI4YXAAEYboMSpE0985.jpg\\\",\\\"fromAccount\\\":\\\"1090883890\\\",\\\"fromClientType\\\":\\\"AOS\\\",\\\"eventType\\\":\\\"4\\\",\\\"roomId\\\":\\\"62818030\\\",\\\"msgidClient\\\":\\\"c9fa8daa8f7c4b5181ae62b8800d3d7b\\\",\\\"resendFlag\\\":\\\"1\\\",\\\"msgTimestamp\\\":\\\"1560932176874\\\",\\\"roleInfoTimetag\\\":\\\"1560932174875\\\",\\\"attach\\\":\\\"{\\\\\\\"data\\\\\\\":{\\\\\\\"fid\\\\\\\":109088389018,\\\\\\\"isAnnounce\\\\\\\":false,\\\\\\\"roomId\\\\\\\":\\\\\\\"62818030\\\\\\\",\\\\\\\"isAuthor\\\\\\\":true,\\\\\\\"specialId\\\\\\\":false,\\\\\\\"uid\\\\\\\":1090883890,\\\\\\\"vipLevel\\\\\\\":1,\\\\\\\"isAuth\\\\\\\":2,\\\\\\\"winTreasureBoughtNum\\\\\\\":0,\\\\\\\"honorList\\\\\\\":[{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http://file.tyi365.com/uploads/user/sys_prop/img_url/5bf3d34e38f9b.png\\\\\\\",\\\\\\\"honorName\\\\\\\":\\\\\\\"月卡会员\\\\\\\",\\\\\\\"subType\\\\\\\":510,\\\\\\\"type\\\\\\\":51},{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"https://yrmanage-uat.tyi365.com/uploads/sys_prop/img_url/5c3c839ca0c24.png\\\\\\\",\\\\\\\"honorName\\\\\\\":\\\\\\\"花星\\\\\\\",\\\\\\\"subType\\\\\\\":621,\\\\\\\"type\\\\\\\":62},{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http://yrmanage-uat.tyi365.com/uploads/sys_prop/img_url/5ce634f7912fc.png\\\\\\\",\\\\\\\"honorName\\\\\\\":\\\\\\\"周年勋章\\\\\\\",\\\\\\\"subType\\\\\\\":538,\\\\\\\"type\\\\\\\":51}],\\\\\\\"nobilityStatus\\\\\\\":0,\\\\\\\"text\\\\\\\":\\\\\\\"我点亮了\\\\\\\",\\\\\\\"level\\\\\\\":32,\\\\\\\"sex\\\\\\\":1,\\\\\\\"textType\\\\\\\":13,\\\\\\\"noticeType\\\\\\\":0,\\\\\\\"isVip\\\\\\\":1,\\\\\\\"tarId\\\\\\\":0,\\\\\\\"mysteryBtn\\\\\\\":2,\\\\\\\"winTreasureId\\\\\\\":0,\\\\\\\"grade\\\\\\\":20,\\\\\\\"name\\\\\\\":\\\\\\\"1号主播\\\\\\\",\\\\\\\"fansClubName\\\\\\\":\\\\\\\"\\\\\\\"},\\\\\\\"type\\\\\\\":400}\\\"}\", \"{\\\"fromNick\\\":\\\"LavalMan\\\",\\\"msgType\\\":\\\"CUSTOM\\\",\\\"fromExt\\\":\\\"\\\",\\\"fromAvator\\\":\\\"http://test-fdfs.ihuajian.com/img/M00/00/24/rB9QBVtbB_-AXccqAAWiuvlNhPI777.png\\\",\\\"fromAccount\\\":\\\"1090883956\\\",\\\"fromClientType\\\":\\\"IOS\\\",\\\"eventType\\\":\\\"4\\\",\\\"roomId\\\":\\\"62818030\\\",\\\"msgidClient\\\":\\\"ee60ef2a-112d-4fcc-b3e2-f59792d7bbb9\\\",\\\"resendFlag\\\":\\\"0\\\",\\\"msgTimestamp\\\":\\\"1560926849206\\\",\\\"roleInfoTimetag\\\":\\\"1560926834115\\\",\\\"attach\\\":\\\"{\\\\\\\"type\\\\\\\":400,\\\\\\\"data\\\\\\\":{\\\\\\\"isAnnounce\\\\\\\":false,\\\\\\\"uid\\\\\\\":1090883956,\\\\\\\"winTreasureId\\\\\\\":0,\\\\\\\"textType\\\\\\\":2,\\\\\\\"isVip\\\\\\\":1,\\\\\\\"level\\\\\\\":30,\\\\\\\"giftNoticeType\\\\\\\":0,\\\\\\\"docs\\\\\\\":[],\\\\\\\"tarName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"vipLevel\\\\\\\":4,\\\\\\\"nobilityStatus\\\\\\\":0,\\\\\\\"fansClubName\\\\\\\":\\\\\\\"粉\\\\\\\",\\\\\\\"avatar\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"winTreasureBoughtNum\\\\\\\":0,\\\\\\\"specialId\\\\\\\":false,\\\\\\\"isAuthor\\\\\\\":false,\\\\\\\"mysteryName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"roomId\\\\\\\":\\\\\\\"62818030\\\\\\\",\\\\\\\"propIcon\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"honorList\\\\\\\":[{\\\\\\\"honorName\\\\\\\":\\\\\\\"女王\\\\\\\",\\\\\\\"type\\\\\\\":52,\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/file.tyi365.com\\\\\\\\/uploads\\\\\\\\/user\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5bf3cd66a7a63.png\\\\\\\"},{\\\\\\\"type\\\\\\\":51,\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/yrmanage-uat.tyi365.com\\\\\\\\/uploads\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5ce634f7912fc.png\\\\\\\",\\\\\\\"honorName\\\\\\\":\\\\\\\"周年勋章\\\\\\\"}],\\\\\\\"tarId\\\\\\\":0,\\\\\\\"reciveUserName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"mysteryBtn\\\\\\\":2,\\\\\\\"fansHonorName\\\\\\\":\\\\\\\"女王\\\\\\\",\\\\\\\"text\\\\\\\":\\\\\\\"关注了主播\\\\\\\",\\\\\\\"noticeType\\\\\\\":0,\\\\\\\"sendUserName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"giftName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"sendUserAvater\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"sex\\\\\\\":1,\\\\\\\"fid\\\\\\\":109088395632,\\\\\\\"name\\\\\\\":\\\\\\\"LavalMan\\\\\\\"}}\\\"}\", \"{\\\"fromNick\\\":\\\"LavalMan\\\",\\\"msgType\\\":\\\"CUSTOM\\\",\\\"fromExt\\\":\\\"\\\",\\\"fromAvator\\\":\\\"http://test-fdfs.ihuajian.com/img/M00/00/24/rB9QBVtbB_-AXccqAAWiuvlNhPI777.png\\\",\\\"fromAccount\\\":\\\"1090883956\\\",\\\"fromClientType\\\":\\\"IOS\\\",\\\"eventType\\\":\\\"4\\\",\\\"roomId\\\":\\\"62818030\\\",\\\"msgidClient\\\":\\\"ee9f27e8-b62f-483b-9d36-1f91c82ace81\\\",\\\"resendFlag\\\":\\\"0\\\",\\\"msgTimestamp\\\":\\\"1560926845204\\\",\\\"yidunRes\\\":\\\"{\\\\\\\"yidunBusType\\\\\\\":0,\\\\\\\"action\\\\\\\":0,\\\\\\\"labels\\\\\\\":[]}\\\",\\\"roleInfoTimetag\\\":\\\"1560926834115\\\",\\\"attach\\\":\\\"{\\\\\\\"data\\\\\\\":{\\\\\\\"mysteryName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"isAuthor\\\\\\\":false,\\\\\\\"tarId\\\\\\\":0,\\\\\\\"fansHonorName\\\\\\\":\\\\\\\"女王\\\\\\\",\\\\\\\"noticeType\\\\\\\":0,\\\\\\\"honorList\\\\\\\":[{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/file.tyi365.com\\\\\\\\/uploads\\\\\\\\/user\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5bf3cd66a7a63.png\\\\\\\",\\\\\\\"type\\\\\\\":52,\\\\\\\"honorName\\\\\\\":\\\\\\\"女王\\\\\\\"},{\\\\\\\"honorName\\\\\\\":\\\\\\\"周年勋章\\\\\\\",\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/yrmanage-uat.tyi365.com\\\\\\\\/uploads\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5ce634f7912fc.png\\\\\\\",\\\\\\\"type\\\\\\\":51}],\\\\\\\"fid\\\\\\\":109088395632,\\\\\\\"propIcon\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"nobilityStatus\\\\\\\":0,\\\\\\\"mysteryBtn\\\\\\\":2,\\\\\\\"avatar\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"textType\\\\\\\":0,\\\\\\\"uid\\\\\\\":1090883956,\\\\\\\"sendUserAvater\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"sex\\\\\\\":1,\\\\\\\"fansClubName\\\\\\\":\\\\\\\"粉\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"LavalMan\\\\\\\",\\\\\\\"tarName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"vipLevel\\\\\\\":4,\\\\\\\"winTreasureBoughtNum\\\\\\\":0,\\\\\\\"docs\\\\\\\":[],\\\\\\\"level\\\\\\\":30,\\\\\\\"text\\\\\\\":\\\\\\\"q\\\\\\\",\\\\\\\"specialId\\\\\\\":false,\\\\\\\"isVip\\\\\\\":1,\\\\\\\"sendUserName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"giftNoticeType\\\\\\\":0,\\\\\\\"isAnnounce\\\\\\\":false,\\\\\\\"winTreasureId\\\\\\\":0,\\\\\\\"roomId\\\\\\\":\\\\\\\"62818030\\\\\\\",\\\\\\\"giftName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"reciveUserName\\\\\\\":\\\\\\\"\\\\\\\"},\\\\\\\"type\\\\\\\":400}\\\"}\", \"{\\\"fromNick\\\":\\\"LavalMan\\\",\\\"msgType\\\":\\\"CUSTOM\\\",\\\"fromExt\\\":\\\"\\\",\\\"fromAvator\\\":\\\"http://test-fdfs.ihuajian.com/img/M00/00/24/rB9QBVtbB_-AXccqAAWiuvlNhPI777.png\\\",\\\"fromAccount\\\":\\\"1090883956\\\",\\\"fromClientType\\\":\\\"IOS\\\",\\\"eventType\\\":\\\"4\\\",\\\"roomId\\\":\\\"62818030\\\",\\\"msgidClient\\\":\\\"e04ccc34-7773-43b1-8753-9904fb8f48ea\\\",\\\"resendFlag\\\":\\\"0\\\",\\\"msgTimestamp\\\":\\\"1560926841515\\\",\\\"roleInfoTimetag\\\":\\\"1560926834115\\\",\\\"attach\\\":\\\"{\\\\\\\"type\\\\\\\":400,\\\\\\\"data\\\\\\\":{\\\\\\\"sendUserName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"noticeType\\\\\\\":0,\\\\\\\"text\\\\\\\":\\\\\\\"我点亮了\\\\\\\",\\\\\\\"propIcon\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"nobilityStatus\\\\\\\":0,\\\\\\\"mysteryName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"isAuthor\\\\\\\":false,\\\\\\\"honorList\\\\\\\":[{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/file.tyi365.com\\\\\\\\/uploads\\\\\\\\/user\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5bf3cd66a7a63.png\\\\\\\",\\\\\\\"type\\\\\\\":52,\\\\\\\"honorName\\\\\\\":\\\\\\\"女王\\\\\\\"},{\\\\\\\"imgUrl\\\\\\\":\\\\\\\"http:\\\\\\\\/\\\\\\\\/yrmanage-uat.tyi365.com\\\\\\\\/uploads\\\\\\\\/sys_prop\\\\\\\\/img_url\\\\\\\\/5ce634f7912fc.png\\\\\\\",\\\\\\\"honorName\\\\\\\":\\\\\\\"周年勋章\\\\\\\",\\\\\\\"type\\\\\\\":51}],\\\\\\\"reciveUserName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"giftName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"vipLevel\\\\\\\":4,\\\\\\\"winTreasureBoughtNum\\\\\\\":0,\\\\\\\"fid\\\\\\\":109088395632,\\\\\\\"textType\\\\\\\":13,\\\\\\\"specialId\\\\\\\":false,\\\\\\\"tarName\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"giftNoticeType\\\\\\\":0,\\\\\\\"roomId\\\\\\\":\\\\\\\"62818030\\\\\\\",\\\\\\\"winTreasureId\\\\\\\":0,\\\\\\\"isVip\\\\\\\":1,\\\\\\\"uid\\\\\\\":1090883956,\\\\\\\"tarId\\\\\\\":0,\\\\\\\"avatar\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"mysteryBtn\\\\\\\":2,\\\\\\\"level\\\\\\\":30,\\\\\\\"sex\\\\\\\":1,\\\\\\\"sendUserAvater\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"fansClubName\\\\\\\":\\\\\\\"粉\\\\\\\",\\\\\\\"fansHonorName\\\\\\\":\\\\\\\"女王\\\\\\\",\\\\\\\"docs\\\\\\\":[],\\\\\\\"name\\\\\\\":\\\\\\\"LavalMan\\\\\\\",\\\\\\\"isAnnounce\\\\\\\":false}}\\\"}\"]"
			+ "	}" + "}";

	public static void main(String[] args) {
		Gson gson = new Gson();
		BaseResponse<LiveHistoryMessageResponse> response = gson.fromJson(result,
				new TypeToken<BaseResponse<LiveHistoryMessageResponse>>() {
				}.getType());
		for (String msg : response.data.getList()) {
			System.out.println(msg);
			JSONObject jsonObject = JSON.parseObject(msg, JSONObject.class);
			JSONObject attachObject=jsonObject.getJSONObject("attach");
//			JSONObject attachObject=JSON.parseObject(attach, JSONObject.class);
			System.out.println(attachObject.toString());
			String data=attachObject.getString("data");
			System.out.println(data);
			break;
		}
	}

	public class BaseResponse<T> implements Serializable {
		@SerializedName("code")
		public int status;
		@SerializedName("message")
		public String msg;
		public T data;

	}

	public class LiveHistoryMessageResponse {

		private List<String> list;

		public List<String> getList() {
			return list;
		}

		public class LiveHistoryMessage {
			private String fromNick;// "LavalMan",
			private String fromAvator;// "http://test-fdfs.ihuajian.com/img/M00/00/24/rB9QBVtbB_-AXccqAAWiuvlNhPI777.png",
			private String fromAccount;// "1090883956",
			private long roomId;
			private LiveHistoryMessageAttach attach;

			public String getFromNick() {
				return fromNick;
			}

			public String getFromAvator() {
				return fromAvator;
			}

			public String getFromAccount() {
				return fromAccount;
			}

			public long getRoomId() {
				return roomId;
			}

			public LiveHistoryMessageAttach getAttach() {
				return attach;
			}
		}

		public class LiveHistoryMessageAttach {
			private int type;
			private String data;

			public int getType() {
				return type;
			}

			public String getData() {
				return data;
			}
		}
	}

}
