package com.alibaba.dubbo.demo.test.extension;

import com.alibaba.dubbo.common.extension.ExtensionFactory;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

public class TestExtension {
	public static void main(String[] args) {
		System.out.println();
		ExtensionFactory adaptiveExtension = ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension();
		Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
		int defaultPort = protocol.getDefaultPort();
		System.out.println(adaptiveExtension);
		System.out.println(protocol);

	}

}
