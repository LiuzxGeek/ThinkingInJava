package com.java.thinking.data.json;

/*
*@author:liuxian
*@date:2018年10月24日
*/
public class MessageVo {
	private int uid;// int 赠送者uid
	private int myAnchorUid;// int 支持者uid
	private int tarUid;// 被使用者uid
	private String nickname;// 赠送者昵称
	private String avatar;// 赠送者头像
	private int propId;// 赠送道具id
	private String propName;// 赠送道具名称
	private int num;// 赠送道具数量
	private String iconUrl;// 赠送道具图标
	private String propSvgUrl;// 赠送道具动效
	private String doc;// 公告
	private boolean sendComment;// 是否发评论

	public boolean isSendComment() {
		return sendComment;
	}

	public String getDoc() {
		return doc;
	}

	public int getUid() {
		return uid;
	}

	public int getMyAnchorUid() {
		return myAnchorUid;
	}

	public int getTarUid() {
		return tarUid;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public int getPropId() {
		return propId;
	}

	public String getPropName() {
		return propName;
	}

	public int getNum() {
		return num;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public String getPropSvgUrl() {
		return propSvgUrl;
	}

	@Override
	public String toString() {
		return "PkPropMessageVo [uid=" + uid + ", myAnchorUid=" + myAnchorUid + ", tarUid=" + tarUid + ", nickname="
				+ nickname + ", avatar=" + avatar + ", propId=" + propId + ", propName=" + propName + ", num=" + num
				+ ", iconUrl=" + iconUrl + ", propSvgUrl=" + propSvgUrl + ", doc=" + doc + ", sendComment="
				+ sendComment + "]";
	}
	
}
