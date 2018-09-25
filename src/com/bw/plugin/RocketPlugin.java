package com.bw.plugin;

import com.jfinal.plugin.IPlugin;

public class RocketPlugin implements IPlugin{

	@Override
	public boolean start() {
		System.out.println("rocket启动");
		return true;
	}

	@Override
	public boolean stop() {
		System.out.println("rocket关闭");
		return true;
	}

}
