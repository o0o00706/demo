package com.example.demo.model;

public class RspCode {

    private String  code;

    // 回傳資料，型別為Object，讓回傳的資料型別可以更多樣化
    private String  message;

    public RspCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public RspCode() {
 
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




}
