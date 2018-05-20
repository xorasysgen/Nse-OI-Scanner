package nse.skbh.springboot.pojo;

import nse.skbh.springboot.logic.Utils;

public class ServerStatus {

	private final String serverDate;
	private final String serverName;
	private final String serverProvider;
	private final String appVersion;
	private final String appName;
	private final String appOwner;
	private final String appOwnerEmail;
	private final String appGoal;
	private final String message;

	public ServerStatus() {
		this.serverDate = Utils.getTimeZoneOfServer();
		this.serverName = "HerokuBootJSR101";
		this.serverProvider = "Heroku";
		this.appVersion = "v1";
		this.appName = "JSR 101 Boot";
		this.appOwner = "skbh";
		this.appOwnerEmail = "xorasysgen@yahoo.com";
		this.appGoal = "F&O equity analysis platform - The Trading & Investing Engine that simplify trades";
		this.message = "JSR101 Boot Micro Service is Running Ok.200";
	}

	public String getServerDate() {
		return serverDate;
	}

	public String getServerName() {
		return serverName;
	}

	public String getServerProvider() {
		return serverProvider;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public String getAppOwnerEmail() {
		return appOwnerEmail;
	}

	public String getAppGoal() {
		return appGoal;
	}

	public String getMessage() {
		return message;
	}

}
