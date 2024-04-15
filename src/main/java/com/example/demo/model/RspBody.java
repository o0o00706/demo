package com.example.demo.model;

public class RspBody {

    private Object RspCode;

    // 回傳資料，型別為Object，讓回傳的資料型別可以更多樣化
    private Object RspData;

    public RspBody(Object RspCode, Object RspData) {
        this.RspCode = RspCode;
        this.RspData = RspData;
    }
    
    public RspBody() {

    }

	public Object getRspCode() {
		return RspCode;
	}

	public void setRspCode(Object rspCode) {
		RspCode = rspCode;
	}

	public Object getRspData() {
		return RspData;
	}

	public void setRspData(Object rspData) {
		RspData = rspData;
	}



}
